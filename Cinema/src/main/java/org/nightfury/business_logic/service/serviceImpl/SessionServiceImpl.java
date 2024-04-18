package org.nightfury.business_logic.service.serviceImpl;

import java.sql.SQLException;
import java.time.LocalDateTime;
import org.nightfury.business_logic.service.GenericService;
import org.nightfury.persistence.entity.entityImpl.Hall;
import org.nightfury.persistence.entity.entityImpl.Movie;
import org.nightfury.persistence.entity.entityImpl.Session;
import org.nightfury.persistence.repository.repositoryImpl.SessionRepositoryImpl;

public class SessionServiceImpl extends GenericService<Session> {

    public SessionServiceImpl() throws SQLException {
        super(new SessionRepositoryImpl());
    }

    public Session createSession(Movie movie, Hall hall, LocalDateTime startDateTime) {
        return super.save(
            Session.builder().movie(movie).hall(hall).startDateTime(startDateTime).build());
    }
}
