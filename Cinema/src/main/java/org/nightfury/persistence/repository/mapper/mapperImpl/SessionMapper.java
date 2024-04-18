package org.nightfury.persistence.repository.mapper.mapperImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.nightfury.persistence.entity.entityImpl.Session;
import org.nightfury.persistence.repository.mapper.RowMapper;

public class SessionMapper implements RowMapper<Session> {

    @Override
    public Session mapRow(ResultSet rs) throws SQLException {
        return Session.builder()
            .id(rs.getInt("session_id"))
            .hall(new HallMapper().mapRow(rs))
            .movie(new MovieMapper().mapRow(rs))
            .startDateTime(rs.getObject("start_datetime", LocalDateTime.class))
            .build();
    }
}
