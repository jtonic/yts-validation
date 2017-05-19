package ro.jtonic.isr.yts.validation.validators;

import org.springframework.stereotype.Component;

@Component
public class PhoneNumberChecker {

    public boolean isValid(String phoneNumber) {
        return phoneNumber != null && phoneNumber.matches("[0-9]+")
                && (phoneNumber.length() > 8) && (phoneNumber.length() < 14);
    }


}
