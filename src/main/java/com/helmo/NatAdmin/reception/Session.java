package com.helmo.NatAdmin.reception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "sessions")
@Getter @Setter
@JsonIgnoreProperties("user")
public class Session extends IdentifiedModel{
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "date_start")
	private Timestamp dateStart;
	@Column(name = "date_end")
	private Timestamp dateEnd;
	
	
	@Column(name = "latitude")
	private String latitude;
	@Column(name = "longitude")
	private String longitude;
	
	@OneToMany(cascade = {CascadeType.PERSIST},
		mappedBy = "session")
	private List<Observation> observations;

	@JoinColumn(name = "id_user")
	@ManyToOne(targetEntity = User.class)
	private User user;
	
	public Session() {}
	
}
