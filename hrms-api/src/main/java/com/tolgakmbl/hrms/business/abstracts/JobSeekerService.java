package com.tolgakmbl.hrms.business.abstracts;

import java.util.List;

import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.entities.concretes.JobSeeker;
import com.tolgakmbl.hrms.entities.concretes.JobSeekersFavoriteJobAdvert;
import com.tolgakmbl.hrms.entities.dtos.JobSeekerForRegisterDto;

public interface JobSeekerService {

	Result add(JobSeeker jobSeeker);

	Result delete(int id);

	DataResult<List<JobSeeker>> getAll();

	DataResult<JobSeeker> getById(int id);

	Result update(JobSeeker jobSeeker);
	
	DataResult<JobSeeker> getByIdentityNumber(String identityNumber);

	Result isNotNationalIdentityExist(String identityNumber);

	Result register(JobSeekerForRegisterDto jobSeekerForRegisterDto);

	DataResult<JobSeekersFavoriteJobAdvert> getFavoriteByJobSeekerIdAndJobAdvertId(int jobSeekerId, int jobAdvertId);

	Result undoFavoriteJobAdvert(int id);

	Result favoriteJobAdvert(JobSeekersFavoriteJobAdvert jobSeekersFavoriteJobAdvert);
}
