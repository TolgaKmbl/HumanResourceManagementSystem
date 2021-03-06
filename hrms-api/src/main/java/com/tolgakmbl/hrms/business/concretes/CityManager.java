package com.tolgakmbl.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tolgakmbl.hrms.business.abstracts.CityService;
import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.core.utilities.results.SuccessDataResult;
import com.tolgakmbl.hrms.core.utilities.results.SuccessResult;
import com.tolgakmbl.hrms.dataAccess.abstracts.CityDao;
import com.tolgakmbl.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService {
	
	private CityDao cityDao;

	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public Result add(City city) {
		cityDao.save(city);
		return new SuccessResult("City added");
	}

	@Override
	public Result delete(short id) {
		cityDao.deleteById(id);
		return new SuccessResult("City deleted");
	}

	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(cityDao.findAll(),"Cities listed");
	}

	@Override
	public DataResult<City> getById(short id) {
		return new SuccessDataResult<City>(cityDao.findById(id).get());
	}

	@Override
	public Result update(City city) {
		cityDao.save(city);
		return new SuccessResult("City updated");
	}

	@Override
	public DataResult<City> getByName(String name) {
		return new SuccessDataResult<City>(cityDao.getByName(name));
	}

	@Override
	public DataResult<List<City>> getByNameContains(String name) {
		return new SuccessDataResult<List<City>>(cityDao.getByNameContains(name));
	}

}
