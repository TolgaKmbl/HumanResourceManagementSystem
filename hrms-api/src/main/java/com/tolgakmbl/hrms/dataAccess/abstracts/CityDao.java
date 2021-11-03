package com.tolgakmbl.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tolgakmbl.hrms.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Short> {

	City getByName(String name);

	List<City> getByNameContains(String name);
	
}
