package org.nightfury.business_logic.service.registration;

import java.sql.SQLException;
import org.nightfury.business_logic.service.exception.FieldsValidationException;
import org.nightfury.business_logic.service.registration.validation.ValidationService;
import org.nightfury.business_logic.service.serviceImpl.UserServiceImpl;
import org.nightfury.persistence.entity.entityImpl.User;

public class RegistrationService {

    public User registerUser(String name, String password) throws FieldsValidationException {
        ValidationService validationService = new ValidationService();
        UserServiceImpl userService = null;
        try {
            userService = new UserServiceImpl();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (validationService.isValidUserName(name) & validationService.isValidPassword(
            password)) {
            return userService.createUser(name, password);
        } else {
            throw new FieldsValidationException(validationService.getErrors());
        }
    }
}
