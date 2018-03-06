package spring.STS.web.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.STS.web.service.UserService;
import spring.STS.web.validation.annotation.UniqueUser;

@Component
public class UniqueUserValidator implements ConstraintValidator<UniqueUser, String> {

	@Autowired
	private UserService userService;
	
	@Override
	public void initialize(UniqueUser arg0) {
		
	}

	@Override
	public boolean isValid(String model, ConstraintValidatorContext context) {
		if(model == null) {
		return false;
		}
		if(userService.findUserByLogin(model) != null) {
			return false;
		}else {
			return true;
		}
		
	}

	
	
}
