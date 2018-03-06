package spring.STS.web.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import spring.STS.web.entity.MyUser;
import spring.STS.web.validation.annotation.ConfirmPassword;

@Component
public class ConfirmPassValidator implements ConstraintValidator<ConfirmPassword, Object> {

	@Override
	public void initialize(ConfirmPassword arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(Object model, ConstraintValidatorContext context) {
		if(model == null) {
			return false;
		}
		MyUser user = (MyUser) model;
		if(!user.getPassword().equals(user.getConfirmPass())) {
			return false;
		}
		
		return true;
	}

}
