package project.iics.tms.controllers.validation_impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.mvel2.MVEL;

import project.iics.tms.controllers.validation.PasswordMatches;

public class PasswordMatches_impl implements ConstraintValidator<PasswordMatches, Object> {
	
	private String firstFieldName;
    private String secondFieldName;
   

	@Override
	public void initialize(final PasswordMatches constraintAnnotation) {
		
		firstFieldName = constraintAnnotation.first();
        secondFieldName = constraintAnnotation.second();
        
    
	}

	@Override
	public boolean isValid(final Object value, final ConstraintValidatorContext context) {
		
			boolean ret = false;
            final Object firstObj;
            final Object secondObj;
            
			firstObj = MVEL.getProperty(firstFieldName, value);
			secondObj = MVEL.getProperty(secondFieldName, value);
			
	
			
			if(firstObj.equals(secondObj)){
				ret = true;
				
			}
			
			context.disableDefaultConstraintViolation();
       	   	context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate()).addPropertyNode(secondFieldName).addConstraintViolation().disableDefaultConstraintViolation();
       	   //context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate()).addNode(secondFieldName).addConstraintViolation();   
		
		return ret;

	}
	

	

}
