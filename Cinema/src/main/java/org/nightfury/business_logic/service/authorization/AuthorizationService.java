package org.nightfury.business_logic.service.authorization;

import java.sql.SQLException;
import org.nightfury.business_logic.service.serviceImpl.UserServiceImpl;
import org.nightfury.persistence.entity.entityImpl.User;

public class AuthorizationService {

    public User logIn(String name, String password) {
        UserServiceImpl userService = null;
        try {
            userService = new UserServiceImpl();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        User user = userService.findByName(name);

       if (user != null) {
           return user.getPassword().equals(password) ? user : null;
       } else {
           return null;
       }
    }
}
