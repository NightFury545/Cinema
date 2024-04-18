package org.nightfury.persistence.repository.mapper.mapperImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.nightfury.persistence.entity.entityImpl.Ticket;
import org.nightfury.persistence.repository.mapper.RowMapper;

public class TicketMapper implements RowMapper<Ticket> {

    @Override
    public Ticket mapRow(ResultSet rs) throws SQLException {
        return Ticket.builder()
            .id(rs.getInt("ticket_id"))
            .session(new SessionMapper().mapRow(rs))
            .seatNumber(rs.getInt("seat_number"))
            .price(rs.getDouble("price"))
            .status(rs.getString("status"))
            .user(new UserMapper().mapRow(rs))
            .build();
    }
}
