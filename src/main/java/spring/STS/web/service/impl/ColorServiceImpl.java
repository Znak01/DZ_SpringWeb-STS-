package spring.STS.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.STS.web.entity.MyColor;
import spring.STS.web.repository.ColorRepository;
import spring.STS.web.service.ColorService;

@Service
public class ColorServiceImpl implements ColorService {

	@Autowired
	private ColorRepository colorRepository;
	
	@Override
	public List<MyColor> findAllColors() {
		return colorRepository.findAll();
	}

}
