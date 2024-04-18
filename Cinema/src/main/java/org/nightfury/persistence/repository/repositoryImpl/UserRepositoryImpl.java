package org.nightfury.persistence.repository.repositoryImpl;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import org.nightfury.persistence.entity.entityImpl.User;
import org.nightfury.persistence.repository.GenericRepository;
import org.nightfury.persistence.repository.mapper.mapperImpl.UserMapper;

public class UserRepositoryImpl extends GenericRepository<User> {

    public UserRepositoryImpl() throws SQLException {
        super(DriverManager.getConnection("jdbc:sqlite:db/Cinema.db"), "users",
            new UserMapper());
    }
    @Override
    protected List<String> tableAttributes() {
        return List.of("user_id", "name", "password");
    }

    @Override
    protected List<Object> tableValues(User entity) {
        return List.of(entity.getName(), entity.getPassword());
    }

    @Override
    protected String additionalQueryArguments() {
        return "";
    }
}
