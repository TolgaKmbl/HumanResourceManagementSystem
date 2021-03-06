package com.tolgakmbl.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tolgakmbl.hrms.entities.concretes.JobSeekerCVImage;

public interface JobSeekerCVImageDao extends JpaRepository<JobSeekerCVImage, Integer>{

	List<JobSeekerCVImage> findAllByJobSeekerCV_Id(int jobSeekerCVId);
	
}
