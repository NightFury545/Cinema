package org.nightfury.business_logic.service.serviceImpl;

import java.sql.SQLException;
import org.nightfury.business_logic.service.GenericService;
import org.nightfury.persistence.entity.entityImpl.User;
import org.nightfury.persistence.repository.exception.AlreadyExistsException;
import org.nightfury.persistence.repository.repositoryImpl.UserRepositoryImpl;

public class UserServiceImpl extends GenericService<User> {

    public UserServiceImpl() throws SQLException {
        super(new UserRepositoryImpl());
    }

    public User createUser(String name, String password) {
        User user = User.builder().name(name).password(password).build();
        return super.save(user);
    }
}
