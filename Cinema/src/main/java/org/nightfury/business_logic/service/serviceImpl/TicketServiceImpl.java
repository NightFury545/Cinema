package org.nightfury.business_logic.service.serviceImpl;

import java.sql.SQLException;
import org.nightfury.business_logic.service.GenericService;
import org.nightfury.persistence.entity.entityImpl.Ticket;
import org.nightfury.persistence.repository.repositoryImpl.TicketRepositoryImpl;

public class TicketServiceImpl extends GenericService<Ticket> {
    public TicketServiceImpl() throws SQLException {
        super(new TicketRepositoryImpl());
    }
}
