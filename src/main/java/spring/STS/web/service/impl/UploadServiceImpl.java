package spring.STS.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.STS.web.entity.UploadFile;
import spring.STS.web.repository.UploadRepository;
import spring.STS.web.service.UploadService;

@Service
public class UploadServiceImpl implements UploadService {

	@Autowired
	private UploadRepository uploadRepository;
	
	@Override
	public void saveFile(UploadFile file) {
		uploadRepository.save(file);

	}

	@Override
	public UploadFile findFileById(int id) {
		return uploadRepository.findOne(id);
	}

}
