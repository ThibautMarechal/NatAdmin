package com.helmo.NatAdmin.reception;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

@Entity
@Table(name = "users")
@Getter @Setter
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class User extends IdentifiedModel {
	
	@Column(name = "full_name")
	@NotEmpty
	private String fullName;
	
	@Column(name = "email")
//	@Email(message = "Please, provide a valid email")
	@NotEmpty
	private String email;
	
	@Column(name = "is_admin")
	private boolean admin = false;
	
	@Column(name = "pic_path")
	private String onlinePath;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.DETACH)
	@JoinTable(
			name = "user_role",
			joinColumns=@JoinColumn(name="id_user"),
			inverseJoinColumns=@JoinColumn(name="id_role"))
	private List<Role> roles;
	
	@OneToMany(cascade = {CascadeType.PERSIST},
			mappedBy = "user")
	private List<Session> sessions;
	
//	@JoinColumn(name = "last_used")
//	@OneToMany(targetEntity = Password.class)
//	@JsonIgnore
//	private Password passwordData;
	
	@Column(name = "password")
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
