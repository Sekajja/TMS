package project.iics.tms.controllers.validation_impl;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.passay.DigitCharacterRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.Rule;
import org.passay.RuleResult;
import org.passay.UppercaseCharacterRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import project.iics.tms.controllers.LoginController;
import project.iics.tms.controllers.validation.ValidPassword;

//import com.google.common.base.Joiner;


public class ValidPassword_impl  implements ConstraintValidator<ValidPassword, String> {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
    @Override
    public void initialize(final ValidPassword arg0) {

    }
    @Override
    public boolean isValid(final String password, final ConstraintValidatorContext context) {
        List<Rule> list = new ArrayList<Rule>();
        list.add(new UppercaseCharacterRule(1));
        list.add(new DigitCharacterRule(1));
    	final PasswordValidator validator = new PasswordValidator(list);
        final RuleResult result = validator.validate(new PasswordData(password));
        if (result.isValid()) {
            return true;
        }
        //context.disableDefaultConstraintViolation();
        //context.buildConstraintViolationWithTemplate(Joiner.on("\n").join(validator.getMessages(result))).addConstraintViolation();
        
        for (String msg : validator.getMessages(result)) {
		    logger.info(msg);
		   
  			}
        
        
        return false;
    }

    /*
     * RuleResult result = validator.validate(new PasswordData(new String(password)));
		if (result.isValid()) {
		  System.out.println("Password is valid");
		} else {
		  System.out.println("Invalid password:");
		  for (String msg : validator.getMessages(result)) {
		    System.out.println(msg);
  			}
     * 
     * 
     * */
    
    
    
    
}