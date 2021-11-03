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

import com.tolgakmbl.hrms.business.abstracts.WorkingTypeService;
import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.entities.concretes.WorkingType;

@RestController
@RequestMapping("/api/workingtypes")
@CrossOrigin
public class WorkingTypesController {
	
	private WorkingTypeService workingTypeService;

	@Autowired
	public WorkingTypesController(WorkingTypeService workingTypeService) {
		super();
		this.workingTypeService = workingTypeService;
	}

	@GetMapping("/getall")
    public DataResult<List<WorkingType>> getAll(){
  	  return workingTypeService.getAll();
    }
	
	@GetMapping("/getbyid/{id}")
    public DataResult<WorkingType> getById(@PathVariable int id){
  	  return workingTypeService.getById(id);
    }
    @PostMapping("/add")
    public Result add(@RequestBody WorkingType workingType){
  	  return workingTypeService.add(workingType);
    }
    @PutMapping("/update")
    public Result update(@RequestBody WorkingType workingType){
  	  return workingTypeService.update(workingType);
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable int id){
  	  return workingTypeService.delete(id);
    }

}
