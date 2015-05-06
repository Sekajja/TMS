package project.iics.tms.controllers.validation_impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import project.iics.tms.controllers.validation.PasswordMatches;
import project.iics.tms.domain.ProjectUser;

public class PasswordMatches_impl implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        ProjectUser user = (ProjectUser) obj;
        return user.getPassword().equals(user.getConfirmpassword());
    }
}