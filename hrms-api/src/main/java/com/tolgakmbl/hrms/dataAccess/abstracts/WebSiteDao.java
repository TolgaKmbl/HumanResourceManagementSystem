package com.tolgakmbl.hrms.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tolgakmbl.hrms.entities.concretes.WebSite;

public interface WebSiteDao extends JpaRepository<WebSite, Integer> {

	Optional<WebSite> findByName(String name);
	
}
