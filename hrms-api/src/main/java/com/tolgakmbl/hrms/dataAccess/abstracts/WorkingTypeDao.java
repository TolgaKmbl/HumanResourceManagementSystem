package com.tolgakmbl.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tolgakmbl.hrms.entities.concretes.WorkingType;

public interface WorkingTypeDao extends JpaRepository<WorkingType, Integer>  {

}
