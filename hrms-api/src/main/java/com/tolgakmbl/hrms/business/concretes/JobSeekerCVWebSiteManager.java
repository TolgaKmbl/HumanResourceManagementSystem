package com.tolgakmbl.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tolgakmbl.hrms.business.abstracts.JobSeekerCVWebSiteService;
import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.core.utilities.results.SuccessDataResult;
import com.tolgakmbl.hrms.core.utilities.results.SuccessResult;
import com.tolgakmbl.hrms.dataAccess.abstracts.JobSeekerCVWebSiteDao;
import com.tolgakmbl.hrms.entities.concretes.JobSeekerCVWebSite;

@Service
public class JobSeekerCVWebSiteManager implements JobSeekerCVWebSiteService {
	
	private JobSeekerCVWebSiteDao jobSeekerCVWebSiteDao;

	@Autowired	
	public JobSeekerCVWebSiteManager(JobSeekerCVWebSiteDao jobSeekerCVWebSiteDao) {
		super();
		this.jobSeekerCVWebSiteDao = jobSeekerCVWebSiteDao;
	}

	@Override
	public Result add(JobSeekerCVWebSite jobSeekerCVWebSite) {
		jobSeekerCVWebSiteDao.save(jobSeekerCVWebSite);
		return new SuccessResult("Job Seeker CV WebSite added");
	}

	@Override
	public Result delete(int id) {
		jobSeekerCVWebSiteDao.deleteById(id);
		return new SuccessResult("Job Seeker CV WebSite deleted");
	}

	@Override
	public DataResult<List<JobSeekerCVWebSite>> getAll() {
		return new SuccessDataResult<List<JobSeekerCVWebSite>>(jobSeekerCVWebSiteDao.findAll(),"Job Seeker CV Websites listed");
	}

	@Override
	public DataResult<JobSeekerCVWebSite> getById(int id) {
		return new SuccessDataResult<JobSeekerCVWebSite>(jobSeekerCVWebSiteDao.findById(id).get());
	}

	@Override
	public Result update(JobSeekerCVWebSite jobSeekerCVWebSite) {
		jobSeekerCVWebSiteDao.save(jobSeekerCVWebSite);
		return new SuccessResult("Job Seeker CV WebSite updated");
	}

	@Override
	public DataResult<List<JobSeekerCVWebSite>> getAllByJobSeekerCV_Id(int jobSeekerCVId) {
		final List<JobSeekerCVWebSite> jobSeekerCVWebSites = jobSeekerCVWebSiteDao
				.findAllByJobSeekerCV_Id(jobSeekerCVId);

		return new SuccessDataResult<>(jobSeekerCVWebSites);
	}

}
