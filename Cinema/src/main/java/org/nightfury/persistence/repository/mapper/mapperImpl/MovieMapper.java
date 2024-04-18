package org.nightfury.persistence.repository.mapper.mapperImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.UUID;
import org.nightfury.persistence.entity.entityImpl.Movie;
import org.nightfury.persistence.repository.mapper.RowMapper;

public class MovieMapper implements RowMapper<Movie> {

    public Movie mapRow(ResultSet rs) throws SQLException {
        return Movie.builder()
            .id(rs.getInt("movie_id"))
            .name(rs.getString("name"))
            .releaseYear(rs.getObject("release_year", LocalDate.class))
            .genre(rs.getString("genre"))
            .duration(rs.getInt("duration"))
            .director(rs.getString("director"))
            .description(rs.getString("description"))
            .build();
    }


}
