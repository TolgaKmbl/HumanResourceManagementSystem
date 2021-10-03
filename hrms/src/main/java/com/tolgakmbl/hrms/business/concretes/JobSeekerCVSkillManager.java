package com.tolgakmbl.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tolgakmbl.hrms.business.abstracts.JobSeekerCVSkillService;
import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.core.utilities.results.SuccessDataResult;
import com.tolgakmbl.hrms.core.utilities.results.SuccessResult;
import com.tolgakmbl.hrms.dataAccess.abstracts.JobSeekerCVSkillDao;
import com.tolgakmbl.hrms.entities.concretes.JobSeekerCVSkill;

@Service
public class JobSeekerCVSkillManager implements JobSeekerCVSkillService {
	
	private JobSeekerCVSkillDao jobSeekerCVSkillDao;

	@Autowired
	public JobSeekerCVSkillManager(JobSeekerCVSkillDao jobSeekerCVSkillDao) {
		super();
		this.jobSeekerCVSkillDao = jobSeekerCVSkillDao;
	}

	@Override
	public Result add(JobSeekerCVSkill jobSeekerCVSkill) {
		jobSeekerCVSkillDao.save(jobSeekerCVSkill);
		return new SuccessResult("Job Seeker CV Skill added");
	}

	@Override
	public Result delete(int id) {
		jobSeekerCVSkillDao.deleteById(id);
		return new SuccessResult("Job Seeker CV Skill deleted");
	}

	@Override
	public DataResult<List<JobSeekerCVSkill>> getAll() {
		return new SuccessDataResult<List<JobSeekerCVSkill>>(jobSeekerCVSkillDao.findAll(),"Job Seeker CV Skills listed");
	}

	@Override
	public DataResult<JobSeekerCVSkill> getById(int id) {
		return new SuccessDataResult<JobSeekerCVSkill>(jobSeekerCVSkillDao.findById(id).get());
	}

	@Override
	public Result update(JobSeekerCVSkill jobSeekerCVSkill) {
		jobSeekerCVSkillDao.save(jobSeekerCVSkill);
		return new SuccessResult("Job Seeker CV Skill updated");
	}

	@Override
	public DataResult<List<JobSeekerCVSkill>> getAllByJobSeekerCV_Id(int jobSeekerCVId) {
		final List<JobSeekerCVSkill> jobSeekerCVSkills = jobSeekerCVSkillDao.findAllByJobSeekerCV_Id(jobSeekerCVId);

		return new SuccessDataResult<>(jobSeekerCVSkills);
	}

}
