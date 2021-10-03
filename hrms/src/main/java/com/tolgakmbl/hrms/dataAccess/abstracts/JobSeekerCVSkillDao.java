package com.tolgakmbl.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tolgakmbl.hrms.entities.concretes.JobSeekerCVSkill;

public interface JobSeekerCVSkillDao extends JpaRepository<JobSeekerCVSkill, Integer>{

	List<JobSeekerCVSkill> findAllByJobSeekerCV_Id(int jobSeekerCVId);
	
}
