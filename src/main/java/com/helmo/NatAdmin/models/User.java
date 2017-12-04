package com.helmo.NatAdmin.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class User extends IdentifiedModel {
	
	private String fullName;
	private String email;
	private boolean isAdmin;
	private String profilePictureUrl;
	
	private String password;
	
	private List<Role> roles;
	private List<Session> sessions;
	
	public User() {
	}
}
