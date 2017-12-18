package com.helmo.NatAdmin.tools;

import com.google.auth.oauth2.ServiceAccountCredentials;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;

@Component
public class HELMoCredentialsProvider {
	public static ServiceAccountCredentials getCredential() {
		try {
			return ServiceAccountCredentials.fromStream(
				  new FileInputStream(
						new ClassPathResource("admin-service-key.json").getFile()));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
