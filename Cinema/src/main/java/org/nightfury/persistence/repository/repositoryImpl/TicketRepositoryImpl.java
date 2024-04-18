package org.nightfury.persistence.repository.repositoryImpl;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import org.nightfury.persistence.entity.entityImpl.Ticket;
import org.nightfury.persistence.repository.GenericRepository;
import org.nightfury.persistence.repository.mapper.mapperImpl.TicketMapper;

public class TicketRepositoryImpl extends GenericRepository<Ticket> {

    public TicketRepositoryImpl() throws SQLException {
        super(DriverManager.getConnection("jdbc:sqlite:db/Cinema.db"), "tickets",
            new TicketMapper());
    }

    @Override
    protected List<String> tableAttributes() {
        return List.of("ticket_id", "session_id", "seat_number", "price", "status", "user_id");
    }

    @Override
    protected List<Object> tableValues(Ticket entity) {
        return List.of(entity.getId(), entity.getSession().getId(), entity.getSeatNumber(),
            entity.getPrice(), entity.getStatus(), entity.getUser().getId());
    }

    @Override
    protected String additionalQueryArguments() {
        return "JOIN sessions ON sessions.session_id=tickets.session_id JOIN users ON tickets.user_id=users.user_id";
    }
}
