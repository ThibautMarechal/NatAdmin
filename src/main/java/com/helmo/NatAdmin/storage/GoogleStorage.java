package com.helmo.NatAdmin.storage;

import com.google.cloud.WriteChannel;
import com.google.cloud.storage.*;
import com.helmo.NatAdmin.tools.HELMoCredentialsProvider;
import org.springframework.core.io.InputStreamSource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@Component
public class GoogleStorage { //TODO Work with path not strings
	
	private final Storage storage;
	private String bucketName;
	
	public GoogleStorage() {
		storage = StorageOptions.newBuilder()
			  .setCredentials(HELMoCredentialsProvider.getCredential())
			  .build()
			  .getService();
		bucketName = "natagora-grimar";
	}
	
	public void uploadPicture(InputStreamSource file, String onlinePath, String ext) throws IOException {
		uploadMedia(file, onlinePath, "image/" + ext);
	}
	
	private void uploadMedia(InputStreamSource file, String onlinePath, String mediaType) throws IOException {
		BlobId blobId = BlobId.of(bucketName, onlinePath);
		BlobInfo blobInfo = BlobInfo
			  .newBuilder(blobId)
			  .setContentType(mediaType)
			  .setAcl(new ArrayList<>(Collections.singletonList(Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER))))
			  .build();
		
		uploadContent(file, blobInfo);
	}
	
	public void uploadFolder(Path fullFolderName) {
		BlobId blobId = BlobId.of(bucketName, fullFolderName + "/");
		BlobInfo blobInfo = BlobInfo
			  .newBuilder(blobId)
			  .setContentType("Folder/folder")
			  .build();
		storage.create(blobInfo, new byte[0]);
	}
	
	private void uploadContent(InputStreamSource uploadInputStream, BlobInfo blobInfo) throws IOException {
		try (WriteChannel writer = storage.writer(blobInfo)) {
			byte[] buffer = new byte[1024];
			try (InputStream input = uploadInputStream.getInputStream()) {
				int limit;
				while ((limit = input.read(buffer)) >= 0) {
					writer.write(ByteBuffer.wrap(buffer, 0, limit));
				}
			}
		}
	}
	
	private boolean isASubfolder(Path path) {
		return path.startsWith("\\");
	}
	public String getPublicLink(Path onlinePath) {
		Blob blob;
		if((blob = createBlob(onlinePath)) == null) throw new IllegalArgumentException("No such blob");
		BlobInfo info = BlobInfo.newBuilder(blob.getBlobId())
				.setAcl(Arrays.asList(Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER)))
				.build();
		try {
			storage.update(info);
		} catch (StorageException ex) {
			return "";
		}
		return "https://storage.googleapis.com/" + bucketName + "/" + onlinePath.toString().replace("\\", "/");
//        return blob.getMediaLink();
	}
	private Blob createBlob(Path path) {
		Blob blob = storage.get(BlobId.of(bucketName, path.toString().replace("\\", "/")));
		if (blob == null) {
			System.out.println("No such object");
			return null;
		}
		return blob;
	}

}
