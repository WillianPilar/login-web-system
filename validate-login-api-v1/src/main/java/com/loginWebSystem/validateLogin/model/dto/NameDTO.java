package com.loginWebSystem.validateLogin.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NameDTO {
	
	@JsonProperty("first")
	public String firstName;

	@JsonProperty("last")
	public String lastName;
	
}
