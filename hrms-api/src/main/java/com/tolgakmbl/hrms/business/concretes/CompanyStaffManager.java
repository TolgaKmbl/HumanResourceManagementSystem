package com.tolgakmbl.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tolgakmbl.hrms.business.abstracts.CompanyStaffService;
import com.tolgakmbl.hrms.core.utilities.business.BusinessRules;
import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.ErrorResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.core.utilities.results.SuccessDataResult;
import com.tolgakmbl.hrms.core.utilities.results.SuccessResult;
import com.tolgakmbl.hrms.dataAccess.abstracts.CompanyStaffDao;
import com.tolgakmbl.hrms.entities.concretes.CompanyStaff;
import com.tolgakmbl.hrms.entities.dtos.CompanyStaffForUpdateDto;

@Service
public class CompanyStaffManager implements CompanyStaffService{
	
	private CompanyStaffDao companyStaffDao;

	@Autowired
	public CompanyStaffManager(CompanyStaffDao companyStaffDao) {
		super();
		this.companyStaffDao = companyStaffDao;
	}
	
	private Result arePasswordMatch(final String password, final String confirmPassword) {
		return password.equals(confirmPassword) ? new SuccessResult() : new ErrorResult("Passwords do not match");
	}

	@Override
	public Result add(CompanyStaff companyStaff) {
		companyStaffDao.save(companyStaff);
		return new SuccessResult("Company Staff added");
	}

	@Override
	public Result delete(int id) {
		companyStaffDao.deleteById(id);
		return new SuccessResult("Company Staff deleted");
	}

	@Override
	public DataResult<List<CompanyStaff>> getAll() {
		return new SuccessDataResult<List<CompanyStaff>>(companyStaffDao.findAll(),"Company Staffs listed");
	}

	@Override
	public DataResult<CompanyStaff> getById(int id) {
		return new SuccessDataResult<CompanyStaff>(companyStaffDao.findById(id).get(),"Company Staff listed");
	}

	@Override
	public Result update(CompanyStaff companyStaff) {
		companyStaffDao.save(companyStaff);
		return new SuccessResult("Company Staff updated");
	}

	@Override
	public Result updateByUser(CompanyStaffForUpdateDto companyStaffForUpdateDto) {
		final Optional<CompanyStaff> companyStaff = companyStaffDao.findById(companyStaffForUpdateDto.getId());
		if (companyStaff.isEmpty())
			return new ErrorResult("User not found");

		final Result businessRulesResult = BusinessRules
				.run(arePasswordMatch(companyStaff.get().getPassword(), companyStaffForUpdateDto.getPassword()));
		if (!businessRulesResult.isSuccess())
			return businessRulesResult;

		companyStaff.get().setFirstName(companyStaffForUpdateDto.getFirstName());
     	companyStaff.get().setLastName(companyStaffForUpdateDto.getLastName());
		companyStaffDao.save(companyStaff.get());

		return new SuccessResult("Employer updated succesfully");
	}	

}
