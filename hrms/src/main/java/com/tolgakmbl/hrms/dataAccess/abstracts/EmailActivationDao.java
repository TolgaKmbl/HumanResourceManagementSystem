package com.tolgakmbl.hrms.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tolgakmbl.hrms.entities.concretes.EmailActivation;

public interface EmailActivationDao extends JpaRepository<EmailActivation, Integer>{

	Optional<EmailActivation> findByEmailAndActivationCode(String email, String activationCode);
	
}
