package spring.STS.web.validation.validator;

import java.util.Objects;
import java.util.stream.Stream;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

import spring.STS.web.service.CarService;
import spring.STS.web.validation.annotation.UniqueCarModel;

@Component
public class UniqueCarModelValidator implements ConstraintValidator<UniqueCarModel, String> {

	@Autowired
	private CarService carService;
	
	private static final SpelExpressionParser PARSER = new SpelExpressionParser();
	
	private String[] fields;

	@Override
	public void initialize(UniqueCarModel constraintAnnotation) {

		fields = constraintAnnotation.value();
		
	}

	@Override
	public boolean isValid(String model, ConstraintValidatorContext context) {
	
		if(model == null) {
			return false;
		}
		for (String string : fields) {
			if (PARSER.parseExpression(string).getValue(model).equals(null)) {
				return false;
			}
		}
	    return true;
			
		
		
	}

//	@Override
//	public boolean isValid(Object value, ConstraintValidatorContext context) {
//        long notNull = Stream.of(fields)
//                .map(field -> PARSER.parseExpression(field).getValue(value))
//                .filter(Objects::nonNull)
//                .count();
//        return notNull != 0;
//    }
}
	
