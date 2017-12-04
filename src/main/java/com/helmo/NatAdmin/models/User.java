package com.helmo.NatAdmin.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
<<<<<<< HEAD
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
/*
    public String getFullName()
    {
        return fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public boolean isAdmin()
    {
        return isAdmin;
    }

    public void setAdmin(boolean admin)
    {
        isAdmin = admin;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }
    */
=======
public class User extends Identifiable
{
    private String fullName;
    private String email;
    private boolean isAdmin;
    private String profilePictureUrl;
>>>>>>> master
}
