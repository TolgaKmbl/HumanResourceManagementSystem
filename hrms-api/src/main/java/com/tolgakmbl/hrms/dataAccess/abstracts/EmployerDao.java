package com.tolgakmbl.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tolgakmbl.hrms.entities.concretes.Employer;


public interface EmployerDao extends JpaRepository<Employer, Integer>{

}
