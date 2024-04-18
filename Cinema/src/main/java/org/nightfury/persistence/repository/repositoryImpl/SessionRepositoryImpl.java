package org.nightfury.persistence.repository.repositoryImpl;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import org.nightfury.persistence.entity.entityImpl.Session;
import org.nightfury.persistence.repository.GenericRepository;
import org.nightfury.persistence.repository.mapper.mapperImpl.SessionMapper;

public class SessionRepositoryImpl extends GenericRepository<Session> {

    public SessionRepositoryImpl() throws SQLException {
        super(DriverManager.getConnection("jdbc:sqlite:db/Cinema.db"), "sessions",
            new SessionMapper());
    }

    @Override
    protected List<String> tableAttributes() {
        return List.of("session_id", "movie_id", "hall_id", "start_datetime");
    }

    @Override
    protected List<Object> tableValues(Session entity) {
        return List.of(entity.getMovie().getId(), entity.getHall().getId(),
            entity.getStartDateTime());
    }

    @Override
    protected String additionalQueryArguments() {
        return "JOIN movies ON movies.movie_id=sessions.movie_id JOIN halls ON halls.hall_id=sessions.hall_id";
    }
}
