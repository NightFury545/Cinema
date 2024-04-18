package org.nightfury.persistence.repository.mapper.mapperImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.nightfury.persistence.entity.entityImpl.Hall;
import org.nightfury.persistence.repository.mapper.RowMapper;

public class HallMapper implements RowMapper<Hall> {

    @Override
    public Hall mapRow(ResultSet rs) throws SQLException {
        return Hall.builder()
            .id(rs.getInt("hall_id"))
            .name(rs.getString("name"))
            .seats(rs.getInt("seats")).build();
    }
}
