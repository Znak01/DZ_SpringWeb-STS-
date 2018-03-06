package spring.STS.web.service;

import spring.STS.web.entity.UploadFile;

public interface UploadService {

	void saveFile(UploadFile file);
	
	UploadFile findFileById(int id);
	
}
