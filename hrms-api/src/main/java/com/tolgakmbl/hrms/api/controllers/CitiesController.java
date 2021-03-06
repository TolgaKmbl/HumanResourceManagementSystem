package com.tolgakmbl.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tolgakmbl.hrms.business.abstracts.CityService;
import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.entities.concretes.City;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin
public class CitiesController {
	
	private CityService cityService;

	@Autowired
	public CitiesController(CityService cityService) {
		super();
		this.cityService = cityService;
	}
	
	@GetMapping("/getall")
    public DataResult<List<City>> getAll(){
  	  return cityService.getAll();
    }
	
	@GetMapping("/getbyid/{id}")
    public DataResult<City> getById(@PathVariable short id){
  	  return cityService.getById(id);
    }
    @PostMapping("/add")
    public Result add(@RequestBody City city){
  	  return cityService.add(city);
    }
    @PutMapping("/update")
    public Result update(@RequestBody City city){
  	  return cityService.update(city);
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable short id){
  	  return cityService.delete(id);
    }
	@GetMapping("/byname")
	public DataResult<City> getByName(String name) {
		return cityService.getByName(name);
	}
	@GetMapping("/bynamecontains")
	public DataResult<List<City>> getByNameContains(String name) {
		return cityService.getByNameContains(name);
	}
}
