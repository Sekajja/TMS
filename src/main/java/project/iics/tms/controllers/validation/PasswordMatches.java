package project.iics.tms.controllers.validation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import project.iics.tms.controllers.validation_impl.PasswordMatches_impl;

	@Documented
	@Target({TYPE, ANNOTATION_TYPE})	
	@Retention(RUNTIME)
	@Constraint(validatedBy = PasswordMatches_impl.class)
	public @interface PasswordMatches {

	    String message() default "Passwords don't match";

	    Class<?>[] groups() default {};

	    Class<? extends Payload>[] payload() default {};
	    
	    /**
	     * @return The first field
	     */
	    String first();

	    /**
	     * @return The second field
	     */
	    String second();
	    

	  
	    @Target({TYPE, ANNOTATION_TYPE})
	    @Retention(RUNTIME)
	    @Documented
	            @interface List
	    {
	    	PasswordMatches[] value();
	    }
	    
	    
	}