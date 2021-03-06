package com.tolgakmbl.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tolgakmbl.hrms.business.abstracts.JobSeekerCVImageService;
import com.tolgakmbl.hrms.core.entities.Image;
import com.tolgakmbl.hrms.core.utilities.helpers.image.ImageService;
import com.tolgakmbl.hrms.core.utilities.helpers.image.cloudinary.CloudinaryImageHelper;
import com.tolgakmbl.hrms.core.utilities.results.*;
import com.tolgakmbl.hrms.dataAccess.abstracts.JobSeekerCVImageDao;
import com.tolgakmbl.hrms.entities.concretes.JobSeekerCVImage;

@Service
public class JobSeekerCVImageManager implements JobSeekerCVImageService{
	
	private JobSeekerCVImageDao jobSeekerCVImageDao;
	private final ImageService imageService;

	@Autowired
	public JobSeekerCVImageManager(JobSeekerCVImageDao jobSeekerCVImageDao, ImageService imageService) {
		super();
		this.jobSeekerCVImageDao = jobSeekerCVImageDao;
		this.imageService = imageService;
	}

	@Override
	public Result add(JobSeekerCVImage jobSeekerCVImage) {
		jobSeekerCVImageDao.save(jobSeekerCVImage);
		return new SuccessResult("Job Seeker CV Image added");
	}

	@Override
	public Result delete(int id) {
		final Optional<JobSeekerCVImage> jobSeekerCVImage = jobSeekerCVImageDao.findById(id);
		if (jobSeekerCVImage.isEmpty())
			return new ErrorDataResult<JobSeekerCVImage>("Job seeker CV image has not found");

		final var imagePublicId = CloudinaryImageHelper.getImagePublicIdFromUrl(jobSeekerCVImage.get().getUrl());
		imageService.delete(imagePublicId);

		jobSeekerCVImageDao.delete(jobSeekerCVImage.get());
		return new SuccessResult("Job Seeker CV Image deleted");
	}

	@Override
	public DataResult<List<JobSeekerCVImage>> getAll() {
		return new SuccessDataResult<List<JobSeekerCVImage>>(jobSeekerCVImageDao.findAll(),"Job Seeker CV Images listed");
	}

	@Override
	public DataResult<JobSeekerCVImage> getById(int id) {
		return new SuccessDataResult<JobSeekerCVImage>(jobSeekerCVImageDao.findById(id).get());
	}

	@Override
	public Result update(JobSeekerCVImage jobSeekerCVImage) {
		jobSeekerCVImageDao.save(jobSeekerCVImage);
		return new SuccessResult("Job Seeker CV Image updated");
	}

	@Override
	public Result addAndSave(JobSeekerCVImage jobSeekerCVImage, MultipartFile file) {
		final Image result = imageService.save(file).getData();
		jobSeekerCVImage.setUrl(result.getUrl());

		return add(jobSeekerCVImage);
	}

	@Override
	public DataResult<List<JobSeekerCVImage>> getAllByJobSeekerCV_Id(int jobSeekerCVId) {
		final List<JobSeekerCVImage> jobSeekerCVImages = jobSeekerCVImageDao.findAllByJobSeekerCV_Id(jobSeekerCVId);

		return new SuccessDataResult<>(jobSeekerCVImages);
	}

}
