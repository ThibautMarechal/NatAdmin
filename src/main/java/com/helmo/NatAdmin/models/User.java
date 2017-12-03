package com.helmo.NatAdmin.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.helmo.NatAdmin.reception.RRole;
import com.helmo.NatAdmin.reception.RSession;
import com.helmo.NatAdmin.reception.RUser;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class User extends IdentifiedModel
	  implements ExchangeObject<RUser> {
	
	private String fullName;
	private String Email;
	private boolean isAdmin;
	private String profilePictureUrl;
	
	private List<Role> roles;
	private List<Session> sessions;
	public User() {
	}
	
	@Override
	public RUser getExchangeModel() {
		RUser rtn = new RUser();
		rtn.setId(this.getId());
		rtn.setFullName(this.fullName);
		rtn.setEmail(this.Email);
		rtn.setAdmin(this.isAdmin);
		rtn.setOnlinePath(this.profilePictureUrl);
		rtn.setRRoles(getRRoles());
		rtn.setRSessions(getRSessions());
		return rtn;
	}
	
	public List<RRole> getRRoles() {
		List<RRole> output = new ArrayList<>();
		for(Role role : roles)
			output.add(role.getExchangeModel());
		return output;
	}
	
	public List<RSession> getRSessions() {
		List<RSession> output = new ArrayList<>();
		for(Session ses : sessions)
			output.add(ses.getExchangeModel());
		return output;
	}
}
