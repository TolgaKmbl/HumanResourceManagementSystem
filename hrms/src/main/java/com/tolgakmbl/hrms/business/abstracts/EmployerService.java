package com.tolgakmbl.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.entities.concretes.Employer;
import com.tolgakmbl.hrms.entities.concretes.EmployerUpdate;
import com.tolgakmbl.hrms.entities.dtos.EmployerForRegisterDto;
import com.tolgakmbl.hrms.entities.dtos.EmployerForUpdateDto;

public interface EmployerService {

	Result add(Employer employer);

	Result delete(int id);

	DataResult<List<Employer>> getAll();

	DataResult<Employer> getById(int id);

	Result update(Employer employer);
	
	DataResult<EmployerUpdate> getLastUpdateByUserId(int id);
	
	DataResult<List<EmployerUpdate>> getAllByIsApprovedAndIsDeleted(boolean isApproved, boolean isDeleted);
	
	Result register(EmployerForRegisterDto employerForRegister);
	
	Result updateByUser(EmployerForUpdateDto employerForUpdateDto, MultipartFile companyImage);
	
	Result verifyUpdate(int employerUpdateId);

	Result denyUpdate(final int employerUpdateId);
}	

