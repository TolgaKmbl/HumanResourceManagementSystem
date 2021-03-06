package com.tolgakmbl.hrms.business.abstracts;

import java.util.List;

import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.entities.concretes.CompanyStaffVerification;

public interface CompanyStaffVerificationService {
	
	Result add(CompanyStaffVerification companyStaffVerification);

	Result delete(int id);

	DataResult<List<CompanyStaffVerification>> getAll();

	DataResult<CompanyStaffVerification> getById(int id);

	Result update(CompanyStaffVerification companyStaffVerification);	

	Result verify(int id);
}
