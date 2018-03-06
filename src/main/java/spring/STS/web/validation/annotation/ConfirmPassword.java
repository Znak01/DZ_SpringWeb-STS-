package spring.STS.web.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import spring.STS.web.validation.validator.ConfirmPassValidator;

@Target(ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ConfirmPassValidator.class)
public @interface ConfirmPassword {

	
	
	String message() default "Password not same";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload> [] payload() default {};
	
}
