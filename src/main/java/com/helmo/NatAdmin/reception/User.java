package com.helmo.NatAdmin.reception;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

@Getter @Setter
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class User extends IdentifiedModel {
	
	@NotEmpty
	private String fullName;
	
//	@Email(message = "Please, provide a valid email")
	@NotEmpty
	private String email;
	
	private boolean admin = false;
	
	private String onlinePath;
	
	private List<Role> roles;
	
	private List<Session> sessions;
	
	private String password;
	
	public User() {}
	
	public User(String fullName, String email, String pass, boolean admin, String onlinePath, List<Role> roles) {
		this.fullName = fullName;
		this.email = email;
		this.admin = admin;
		this.password = pass;
		this.onlinePath = onlinePath;
		this.roles = roles;
	}
}
