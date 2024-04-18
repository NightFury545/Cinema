package org.nightfury.persistence.repository.repositoryImpl;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import org.nightfury.persistence.entity.entityImpl.Hall;
import org.nightfury.persistence.repository.GenericRepository;
import org.nightfury.persistence.repository.mapper.mapperImpl.HallMapper;

public class HallRepositoryImpl extends GenericRepository<Hall> {

    public HallRepositoryImpl() throws SQLException {
        super(DriverManager.getConnection("jdbc:sqlite:db/Cinema.db"), "halls",
            new HallMapper());
    }
    @Override
    protected List<String> tableAttributes() {
        return List.of("hall_id", "name", "seats");
    }

    @Override
    protected List<Object> tableValues(Hall entity) {
        return List.of(entity.getId(), entity.getName(), entity.getSeats());

    }

    @Override
    protected String additionalQueryArguments() {
        return "";
    }
}
