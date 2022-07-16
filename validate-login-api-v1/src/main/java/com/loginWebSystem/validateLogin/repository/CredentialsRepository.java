package com.loginWebSystem.validateLogin.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loginWebSystem.validateLogin.model.Credentials;

@Repository
@Transactional
public interface CredentialsRepository extends JpaRepository<Credentials, Integer>{
	
//	@Query(value = "select * from tb_credentials where email :email", nativeQuery = true)
//	List<Credentials> findByEmail(@Param("email") String email);

	List<Credentials> findByEmail(String email);
	
}
