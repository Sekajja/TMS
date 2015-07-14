package project.iics.tms.controllers.validation_impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import project.iics.tms.controllers.validation.ValidPhone;

public class ValidPhone_impl implements ConstraintValidator<ValidPhone, String> {

	@Override
	public void initialize(ValidPhone constraintAnnotation) {
	
	}

	@Override
	public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
		/*
		 * If it doesn't begin with a '+' assume Ugandan
		 * 
		 * 
		 * Valid for  ISO, UK/US and international numbers
		 * ValidationExpression="^[+]?([0-9]*[\.\s\-\(\)]|[0-9]+){3,24}$"
		 * [+]?([0-9]*[\\.\\s\\-\\(\\)]|[0-9]+){3,24}
		 * 
		 * meet complex;
		 * 1?\W*([2-9][0-8][0-9])\W*([2-9][0-9]{2})\W*([0-9]{4})(\se?x?t?(\d*))?
		 * 
		 * and even more complex
		 * '1?\s*\W?\s*([2-9][0-8][0-9])\s*\W?\s*([2-9][0-9]{2})\s*\W?\s*([0-9]{4})(\se?x?t?(\d*))?';
		 * 
		 */


		
		if(phoneNumber == null){
            return false;
        }
		
		if(phoneNumber.matches("07\\d{8}[0-9]*")){
			return true;
		}
		if(phoneNumber.matches("04\\d{8}[0-9]*")){
			return true;
		}
		if(phoneNumber.matches("0[01235689]\\d{8}[0-9]*")){
			return true;
		}
		if(phoneNumber.matches("\\(\\d{3}\\)\\-\\d{1}\\-\\d{3}[\\s]+\\d{3}[\\s]*[0-9]*")){
			return true;
		}
		else if(phoneNumber.matches("[+]([0-9]*[\\.\\s\\-\\(\\)]|[0-9]+){3,24}")){
			return true;
		}
		
		
	return false;
	}

}
