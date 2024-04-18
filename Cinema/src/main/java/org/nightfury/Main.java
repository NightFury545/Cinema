package org.nightfury;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.nightfury.business_logic.service.authorization.AuthorizationService;
import org.nightfury.business_logic.service.exception.FieldsValidationException;
import org.nightfury.business_logic.service.registration.RegistrationService;
import org.nightfury.persistence.entity.entityImpl.User;
import org.nightfury.persistence.repository.exception.AlreadyExistsException;
import java.util.List;
import org.nightfury.presentation.GUIstarter.AppGUI;

public class Main {

    public static void main(String[] args) {
        AppGUI appGUI = new AppGUI();
        appGUI.launchGUI();
        /*List<String> fieldsList = Arrays.stream(User.class.getDeclaredFields())
            .toList()
            .stream()
            .map(Field::getName)
            .toList();
        fieldsList.forEach(System.out::println);*/

    }
}