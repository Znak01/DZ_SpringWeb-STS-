package spring.STS.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.STS.web.entity.MyUser;
import spring.STS.web.repository.UserRepository;
import spring.STS.web.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void save(MyUser user) {
		userRepository.save(user);
		
	}

	@Override
	public MyUser findById(int id) {
		return userRepository.findOne(id);
	}

	@Override
	public List<MyUser> findAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public MyUser findUserByLogin(String model) {
		return userRepository.findUserByLogin(model);
	}
	
	
	
	
}
