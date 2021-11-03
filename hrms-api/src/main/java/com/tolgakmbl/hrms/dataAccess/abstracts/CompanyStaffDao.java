package com.tolgakmbl.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tolgakmbl.hrms.entities.concretes.CompanyStaff;


public interface CompanyStaffDao extends JpaRepository<CompanyStaff, Integer>{

}
