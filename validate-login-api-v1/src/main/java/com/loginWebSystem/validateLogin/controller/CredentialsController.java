package com.loginWebSystem.validateLogin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loginWebSystem.validateLogin.model.Credentials;
import com.loginWebSystem.validateLogin.model.dto.RegistrationDTO;
import com.loginWebSystem.validateLogin.service.CredentialsService;
import com.loginWebSystem.validateLogin.service.impl.CredentialsServiceImpl;

@RestController
@RequestMapping(value = "/validate-login/api/v1")
@CrossOrigin("http://localhost:4200")
public class CredentialsController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CredentialsController.class);

	@Autowired
	private CredentialsService service = new CredentialsServiceImpl();

	@PostMapping("/registration")
	public ResponseEntity<?> registration(@RequestBody RegistrationDTO registrationInfos) {

		try {

			Credentials credentials = new Credentials(registrationInfos);

			List<Credentials> credentialsByEmail = service.findByEmail(credentials.email);
			if (!credentialsByEmail.isEmpty()) {
				return ResponseEntity.badRequest().body("Email is already in use");
			}

			service.save(credentials);

		} catch (Exception e) {
			LOGGER.error("Erro na tentativa de cadastro: ", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/login")
	public ResponseEntity<?> login(@RequestHeader("email") String email, @RequestHeader("key") String password) {

		try {

			List<Credentials> credentialsByEmail = service.findByEmail(email);
			if (credentialsByEmail.isEmpty()) {
				return ResponseEntity.badRequest().body("User not registered");
			} else {

				Credentials credential = credentialsByEmail.get(0);
				if (!credential.password.equals(password)) {
					return ResponseEntity.badRequest().body("Incorrect password");
				}

				if (credential.password.equals(password)) {
					return ResponseEntity.ok().body("Login successfully");
				}

			}
		} catch (Exception e) {
			LOGGER.error("Erro na tentativa de login: ", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return ResponseEntity.badRequest().body("Erro ao realizar o login");

	}

}
