package com.tolgakmbl.hrms.business.abstracts;

import java.util.List;

import com.tolgakmbl.hrms.core.utilities.results.*;
import com.tolgakmbl.hrms.entities.concretes.City;

public interface CityService {
	
	Result add(City city);

	Result delete(short id);

	DataResult<List<City>> getAll();

	DataResult<City> getById(short id);

	Result update(City city);
	
	DataResult<City> getByName(String name);

	DataResult<List<City>> getByNameContains(String name);
}
