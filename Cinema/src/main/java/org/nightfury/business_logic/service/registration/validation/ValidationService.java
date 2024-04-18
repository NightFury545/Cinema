package org.nightfury.business_logic.service.registration.validation;

import java.util.List;

public class ValidationService {

    private final ErrorsContainer errorsContainer = new ErrorsContainer();

    public boolean isValidUserName(String name) {
        validateField(name, "І'мя", 4, 16);

        return errorsContainer.getErrors().isEmpty();
    }

    public boolean isValidPassword(String password) {
        validateField(password, "Пароль", 8, 24);

        return errorsContainer.getErrors().isEmpty();
    }

    public List<String> getErrors() {
        List<String> errors = List.copyOf(errorsContainer.getErrors());
        errorsContainer.clearErrors();
        return errors;
    }

    private void validateField(String field, String templateName, int minLength, int maxLength) {
        if (field.length() < minLength) {
            errorsContainer.addError(
                ErrorTemplate.MIN_LENGTH.getTemplate().formatted(templateName, minLength));
        }

        if (field.length() > maxLength) {
            errorsContainer.addError(
                ErrorTemplate.MAX_LENGTH.getTemplate().formatted(templateName, maxLength));
        }

        if (!field.matches("^[a-zA-Z0-9]+$\n")) {
            errorsContainer.addError(ErrorTemplate.ONLY_LATIN.getTemplate().formatted(templateName));
        }
    }
}
