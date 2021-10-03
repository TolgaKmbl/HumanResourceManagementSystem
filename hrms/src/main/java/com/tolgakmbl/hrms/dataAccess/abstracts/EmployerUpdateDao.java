package com.tolgakmbl.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tolgakmbl.hrms.entities.concretes.EmployerUpdate;

public interface EmployerUpdateDao extends JpaRepository<EmployerUpdate, Integer>{

	List<EmployerUpdate> findAllByEmployer_IdOrderByUpdatedAtDesc(int employerId);

	List<EmployerUpdate> findAllByIsApprovedAndIsDeleted(boolean isApproved, boolean isDeleted);
	
}
