package spring.STS.web.service;

import java.util.List;

import spring.STS.web.entity.MyUser;


public interface UserService {

	void save(MyUser user);
	
	MyUser findById(int id);
	
	List<MyUser> findAllUsers();
	
	MyUser findUserByLogin(String model);
	
}
