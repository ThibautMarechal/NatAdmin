package com.helmo.NatAdmin.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class User extends IdentifiedModel {
	private String fullName;
	private String email;
	private boolean isAdmin;
	private String profilePictureUrl;
	private String publicLink;
	private String password;
	
	private List<Role> roles;
	private List<Session> sessions;
	
	public User() {
	}
}
