package com.helmo.NatAdmin.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SessionForm {
	@NotNull
	@Size(min = 1, max = 50)
	private String name;
	
	public String getName() {
		return name;
	}
}
