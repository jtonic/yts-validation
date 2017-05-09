package ro.jtonic.isr.yts.validation.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements
        ConstraintValidator<PhoneNumberConstraint, String> {
 
    @Override
    public void initialize(PhoneNumberConstraint contactNumber) {
    }
 
    @Override
    public boolean isValid(String field,
      ConstraintValidatorContext cxt) {
        return field != null && field.matches("[0-9]+")
          && (field.length() > 8) && (field.length() < 14);
    }
 
}