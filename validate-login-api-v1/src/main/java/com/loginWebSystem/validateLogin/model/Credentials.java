package com.loginWebSystem.validateLogin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.loginWebSystem.validateLogin.model.dto.RegistrationDTO;

@Entity
@Table(name = "tb_credentials")
public class Credentials {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;


	@Column(name = "firstName")
	public String firstName;

	@Column(name = "lastName")
	public String lastName;

	@Column(unique = true, name = "email")
	public String email;

	@Column(name = "password")
	public String password;

	public Credentials(RegistrationDTO registrationInfos) {
		this.firstName = registrationInfos.name.firstName;
		this.lastName = registrationInfos.name.lastName;
		this.email = registrationInfos.emailAddress;
		this.password = registrationInfos.password;
	}

	public Credentials() {
		super();
	}

}
