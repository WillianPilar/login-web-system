package com.loginWebSystem.validateLogin.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegistrationDTO {
	
	@JsonProperty("name")
	public NameDTO name;
	
	@JsonProperty("email")
	public String emailAddress;
	
	@JsonProperty("key")
	public String password;

}
