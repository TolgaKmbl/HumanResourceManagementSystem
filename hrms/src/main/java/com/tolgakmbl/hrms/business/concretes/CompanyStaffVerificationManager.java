package com.tolgakmbl.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tolgakmbl.hrms.business.abstracts.CompanyStaffVerificationService;
import com.tolgakmbl.hrms.core.utilities.results.*;
import com.tolgakmbl.hrms.dataAccess.abstracts.CompanyStaffVerificationDao;
import com.tolgakmbl.hrms.entities.concretes.CompanyStaffVerification;

@Service
public class CompanyStaffVerificationManager implements CompanyStaffVerificationService{
	
	private CompanyStaffVerificationDao companyStaffVerificationDao;

	@Autowired
	public CompanyStaffVerificationManager(CompanyStaffVerificationDao companyStaffVerificationDao) {
		super();
		this.companyStaffVerificationDao = companyStaffVerificationDao;
	}

	@Override
	public Result add(CompanyStaffVerification companyStaffVerification) {
		companyStaffVerificationDao.save(companyStaffVerification);
		return new SuccessResult("Company Staff Verification added");
	}

	@Override
	public Result delete(int id) {
		companyStaffVerificationDao.deleteById(id);
		return new SuccessResult("Company Staff Verification deleted");
	}

	@Override
	public DataResult<List<CompanyStaffVerification>> getAll() {
		return new SuccessDataResult<List<CompanyStaffVerification>>(companyStaffVerificationDao.findAll(),"Company Staff Verifications listed");
	}

	@Override
	public DataResult<CompanyStaffVerification> getById(int id) {
		return new SuccessDataResult<CompanyStaffVerification>(companyStaffVerificationDao.findById(id).get());
	}

	@Override
	public Result update(CompanyStaffVerification companyStaffVerification) {
		companyStaffVerificationDao.save(companyStaffVerification);
		return new SuccessResult("Company Staff Verification updated");
	}

	@Override
	public Result verify(int id) {
		final DataResult<CompanyStaffVerification> companyStaffVerification = getById(id);

		if (!companyStaffVerification.isSuccess())
			return new ErrorResult("Company staff has not found");

		companyStaffVerification.getData().setApproved(true);
		companyStaffVerificationDao.save(companyStaffVerification.getData());

		return new SuccessResult("Company staff has verified");
	}

}
