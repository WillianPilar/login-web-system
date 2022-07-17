package com.loginWebSystem.validateLogin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginWebSystem.validateLogin.model.Credentials;
import com.loginWebSystem.validateLogin.repository.CredentialsRepository;
import com.loginWebSystem.validateLogin.service.CredentialsService;

@Service
public class CredentialsServiceImpl implements CredentialsService{

	@Autowired
	private CredentialsRepository repository;
	
	@Override
	public String save(Credentials credentials) {
		
		try {
			this.repository.save(credentials);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}

	@Override
	public List<Credentials> findByEmail(String email) {
		
		List<Credentials> credentialsReturn = this.repository.findByEmail(email);
		
		return credentialsReturn;
		
	}

}
