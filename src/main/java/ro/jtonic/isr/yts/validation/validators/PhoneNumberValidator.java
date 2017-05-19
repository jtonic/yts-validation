package ro.jtonic.isr.yts.validation.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements
        ConstraintValidator<PhoneNumberConstraint, String> {

    private final PhoneNumberChecker phoneNumberChecker;

    public PhoneNumberValidator(PhoneNumberChecker phoneNumberChecker) {
        this.phoneNumberChecker = phoneNumberChecker;
    }

    @Override
    public void initialize(PhoneNumberConstraint contactNumber) {
    }
 
    @Override
    public boolean isValid(String field, ConstraintValidatorContext cxt) {
        return phoneNumberChecker.isValid(field);
    }
 
}