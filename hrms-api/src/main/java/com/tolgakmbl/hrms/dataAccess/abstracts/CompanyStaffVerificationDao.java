package com.tolgakmbl.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tolgakmbl.hrms.entities.concretes.CompanyStaffVerification;


public interface CompanyStaffVerificationDao extends JpaRepository<CompanyStaffVerification, Integer>{
	
}
