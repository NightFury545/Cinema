package org.nightfury.persistence.repository.mapper.mapperImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.nightfury.persistence.entity.entityImpl.User;
import org.nightfury.persistence.repository.mapper.RowMapper;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs) throws SQLException {
        return User.builder()
            .id(rs.getInt("user_id"))
            .name(rs.getString("name"))
            .password(rs.getString("password"))
            .build();
    }
}
