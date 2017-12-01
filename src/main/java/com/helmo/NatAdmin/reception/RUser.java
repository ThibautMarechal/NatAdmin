package com.helmo.NatAdmin.reception;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.helmo.NatAdmin.models.Role;
import com.helmo.NatAdmin.models.Session;
import com.helmo.NatAdmin.models.User;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class RUser extends IdentifiedModel
		implements ReceptionObject<User> {
	
	@NotEmpty
	private String fullName;
	
	//@Email(message = "Please, provide a valid email")
	@NotEmpty
	private String email;
	
	private boolean admin = false;
	
	private String onlinePath;
	
	@JsonProperty("roles")
	private List<RRole> rRoles;
	@JsonProperty("sessions")
	private List<RSession> rSessions;
	
	private String password;
	
	public RUser() {
	}
	
	public RUser(String fullName, String email, String pass, boolean admin, String onlinePath, List<RRole> rRoles) {
		this.fullName = fullName;
		this.email = email;
		this.admin = admin;
		this.password = pass;
		this.onlinePath = onlinePath;
		this.rRoles = rRoles;
	}
	
	@Override
	public User getModel() {
		User output = new User();
		output.setId(this.getId());
		output.setFullName(this.fullName);
		output.setEmail(this.email);
		output.setAdmin(this.admin);
		output.setProfilePictureUrl(this.onlinePath);
		output.setRoles(getRoles());
		output.setSessions(getSessions());
		return output;
	}
	
	public List<Role> getRoles() {
		List<Role> output = new ArrayList<>();
		for (RRole item : rRoles)
			output.add(item.getModel());
		return output;
	}
	
	public List<Session> getSessions() {
		List<Session> output = new ArrayList<>();
		for (RSession item : rSessions)
			output.add(item.getModel());
		return output;
	}
}
