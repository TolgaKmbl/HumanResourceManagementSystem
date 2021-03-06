package com.tolgakmbl.hrms.business.abstracts;

import java.util.List;

import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.entities.concretes.CompanyStaff;
import com.tolgakmbl.hrms.entities.dtos.CompanyStaffForUpdateDto;

public interface CompanyStaffService {
	
	Result add(CompanyStaff companyStaff);

	Result delete(int id);

	DataResult<List<CompanyStaff>> getAll();

	DataResult<CompanyStaff> getById(int id);

	Result update(CompanyStaff companyStaff);
	
	Result updateByUser(CompanyStaffForUpdateDto employerForUpdateDto);
	
}
