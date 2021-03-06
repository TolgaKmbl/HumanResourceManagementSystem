package com.tolgakmbl.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.tolgakmbl.hrms.business.abstracts.JobAdvertService;
import com.tolgakmbl.hrms.core.utilities.results.*;
import com.tolgakmbl.hrms.dataAccess.abstracts.JobAdvertDao;
import com.tolgakmbl.hrms.entities.concretes.JobAdvert;
import com.tolgakmbl.hrms.entities.dtos.JobAdvertForListDto;

@Service
public class JobAdvertManager implements JobAdvertService{
	
	private JobAdvertDao jobAdvertDao;

	@Autowired	
	public JobAdvertManager(JobAdvertDao jobAdvertDao) {
		super();
		this.jobAdvertDao = jobAdvertDao;
	}

	@Override
	public Result add(JobAdvert jobAdvert) {
		jobAdvertDao.save(jobAdvert);
		return new SuccessResult("Job Advert added");
	}

	@Override
	public Result delete(int id) {
		jobAdvertDao.deleteById(id);
		return new SuccessResult("Job Advert deleted");
	}

	@Override
	public DataResult<List<JobAdvert>> getAll() {
		return new SuccessDataResult<List<JobAdvert>>(jobAdvertDao.findAll(),"Job Adverts listed");
	}

	@Override
	public DataResult<JobAdvert> getById(int id) {
		return new SuccessDataResult<JobAdvert>(jobAdvertDao.findById(id).get());
	}

	@Override
	public Result update(JobAdvert jobAdvert) {
		jobAdvertDao.save(jobAdvert);
		return new SuccessResult("Job Advert updated");
	}

	@Override
	public Result verifyById(int id) {
		Optional<JobAdvert> jobAdvert = jobAdvertDao.findById(id);
		if (jobAdvert.isEmpty())
			return new ErrorResult("Job advert has not found");

		jobAdvert.get().setActive(true);

		return update(jobAdvert.get());
	}

	@Override
	public DataResult<Page<JobAdvert>> getAllByIsActive(boolean isActive, int page, int size, 
			String[] sortProperties, Direction sortDirection) {
		Page<JobAdvert> jobAdverts = jobAdvertDao.findAllByIsActive(isActive,
				PageRequest.of(page, size, Sort.by(sortDirection,sortProperties)));

		return new SuccessDataResult<>(jobAdverts);
	}

	@Override
	public DataResult<Page<JobAdvertForListDto>> getAllByIsActiveAndEmployer_CompanyNameForList(boolean isActive,
			String companyName, int page, int size, String[] sortProperties, Direction sortDirection) {
		Page<JobAdvertForListDto> jobAdvertForListDtos = jobAdvertDao.findAllByIsActiveAndEmployer_CompanyNameForList(
				isActive,
				companyName,
				PageRequest.of(page, size, Sort.by(sortDirection,sortProperties)));

		return new SuccessDataResult<>(jobAdvertForListDtos);
	}

	@Override
	public DataResult<Page<JobAdvertForListDto>> getAllByIsActiveForList(boolean isActive, int page, int size,
			String[] sortProperties, Direction sortDirection) {
		Page<JobAdvertForListDto> jobAdvertForListDtos = jobAdvertDao.findAllByIsActiveForList(isActive,
				PageRequest.of(page, size, Sort.by(sortDirection,sortProperties)));

		return new SuccessDataResult<>(jobAdvertForListDtos);
	}

	@Override
	public DataResult<Page<JobAdvertForListDto>> getAllByIsActiveAndCityAndWorkingTimeForList(boolean isActive,
			short cityId, short workingTimeId, int page, int size, String[] sortProperties, Direction sortDirection) {
		Page<JobAdvertForListDto> jobAdvertForListDtos = jobAdvertDao.findAllByIsActiveAndCityAndWorkingTimeForList(
				isActive,
				cityId,
				workingTimeId,
				PageRequest.of(page, size, Sort.by(sortDirection,sortProperties)));

		return new SuccessDataResult<>(jobAdvertForListDtos);
	}

}
