package org.nightfury.business_logic.service.serviceImpl;

import java.sql.SQLException;
import org.nightfury.business_logic.service.GenericService;
import org.nightfury.persistence.entity.entityImpl.Hall;
import org.nightfury.persistence.repository.repositoryImpl.HallRepositoryImpl;

public class HallServiceImpl extends GenericService<Hall> {
    public HallServiceImpl() throws SQLException {
        super(new HallRepositoryImpl());
    }
}
