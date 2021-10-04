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

import com.tolgakmbl.hrms.business.abstracts.WorkingTimeService;
import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.entities.concretes.WorkingTime;

@RestController
@RequestMapping("/api/workingtimes")
@CrossOrigin
public class WorkingTimesController {
	
	private WorkingTimeService workingTimeService;

	@Autowired
	public WorkingTimesController(WorkingTimeService workingTimeService) {
		super();
		this.workingTimeService = workingTimeService;
	}
	
	@GetMapping("/getall")
    public DataResult<List<WorkingTime>> getAll(){
  	  return workingTimeService.getAll();
    }
	
	@GetMapping("/getbyid/{id}")
    public DataResult<WorkingTime> getById(@PathVariable int id){
  	  return workingTimeService.getById(id);
    }
    @PostMapping("/add")
    public Result add(@RequestBody WorkingTime workingTime){
  	  return workingTimeService.add(workingTime);
    }
    @PutMapping("/update")
    public Result update(@RequestBody WorkingTime workingTime){
  	  return workingTimeService.update(workingTime);
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable int id){
  	  return workingTimeService.delete(id);
    }

}
