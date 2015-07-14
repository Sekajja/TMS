package project.iics.tms.controllers.validation_impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import project.iics.tms.controllers.validation.ValidName;

public class ValidName_impl implements ConstraintValidator<ValidName, String> {

	@Override
	public void initialize(ValidName constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String name, ConstraintValidatorContext context) {
		
		if(name.matches("[A-Za-z]+[\\s]*") || name.isEmpty()){
			return true;
		}
		
		if(name.matches("[0-9]+[\\s]*")){
			context.buildConstraintViolationWithTemplate("You are not a dollar bill,wait.. are you?").addConstraintViolation().disableDefaultConstraintViolation();
			return false;
		}
		
		
		return false;
	}

}
