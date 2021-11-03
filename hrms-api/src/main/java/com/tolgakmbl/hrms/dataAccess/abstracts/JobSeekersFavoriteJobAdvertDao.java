package com.tolgakmbl.hrms.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tolgakmbl.hrms.entities.concretes.JobSeekersFavoriteJobAdvert;

public interface JobSeekersFavoriteJobAdvertDao extends JpaRepository<JobSeekersFavoriteJobAdvert, Integer>{

	Optional<JobSeekersFavoriteJobAdvert> findByJobSeeker_IdAndJobAdvert_Id(int jobSeekerId, int jobAdvertId);
	
}
