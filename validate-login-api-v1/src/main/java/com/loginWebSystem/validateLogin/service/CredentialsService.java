package com.loginWebSystem.validateLogin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.loginWebSystem.validateLogin.model.Credentials;

@Service
public interface CredentialsService {

	public String save(Credentials credentials);

	public List<Credentials> findByEmail(String email);
	
}
