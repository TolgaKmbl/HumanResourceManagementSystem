package com.tolgakmbl.hrms.business.abstracts;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.entities.concretes.JobAdvert;
import com.tolgakmbl.hrms.entities.dtos.JobAdvertForListDto;

public interface JobAdvertService {

	Result add(JobAdvert jobAdvert);

	Result delete(int id);

	DataResult<List<JobAdvert>> getAll();

	DataResult<JobAdvert> getById(int id);

	Result update(JobAdvert jobAdvert);
	
	Result verifyById(int id);

	DataResult<Page<JobAdvert>> getAllByIsActive(boolean isActive, int page, int size,
			String[] sortProperties, Sort.Direction sortDirection);

	DataResult<Page<JobAdvertForListDto>> getAllByIsActiveAndEmployer_CompanyNameForList(boolean isActive,
			String companyName, int page, int size, String[] sortProperties, Sort.Direction sortDirection);

	DataResult<Page<JobAdvertForListDto>> getAllByIsActiveForList(boolean isActive, int page, int size,
			String[] sortProperties, Sort.Direction sortDirection);

	DataResult<Page<JobAdvertForListDto>> getAllByIsActiveAndCityAndWorkingTimeForList(boolean isActive, short cityId,
			short workingTimeId, int page, int size, String[] sortProperties, Sort.Direction sortDirection);
}
