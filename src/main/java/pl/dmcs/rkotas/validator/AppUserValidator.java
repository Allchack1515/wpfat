package pl.dmcs.rkotas.validator;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pl.dmcs.rkotas.domain.AppUser;

public class AppUserValidator implements Validator {

    EmailValidator emailValidator = EmailValidator.getInstance();

    @Override
    public boolean supports(Class clazz) {
        return AppUser.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AppUser user = (AppUser) target;

        ValidationUtils.rejectIfEmpty(errors, "firstName", "error.field.required");
        ValidationUtils.rejectIfEmpty(errors, "lastName", "error.field.required");
        ValidationUtils.rejectIfEmpty(errors, "telephone", "error.field.required");
        ValidationUtils.rejectIfEmpty(errors, "email", "error.field.required");

        if (errors.getErrorCount() == 0) {
            // Email check
            if (StringUtils.hasText(user.getEmail()) && !emailValidator.isValid(user.getEmail())) {
                errors.rejectValue("email", "error.email.invalid");
            }

            // Telephone format check
            if (!user.getTelephone().matches("\\+\\d{2}-\\d{3}-\\d{3}-\\d{3}")) {
                errors.rejectValue("telephone", "error.telephone.invalidFormat");
            }
        }
    }


}

