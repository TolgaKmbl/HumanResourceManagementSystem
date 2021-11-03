package com.tolgakmbl.hrms.core.utilities.helpers.image;

import org.springframework.web.multipart.MultipartFile;

import com.tolgakmbl.hrms.core.entities.Image;
import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;

public interface ImageService {
	DataResult<Image> save(MultipartFile file);

	Result delete(String id);
}
