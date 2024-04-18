package org.nightfury.persistence.repository.repositoryImpl;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.nightfury.persistence.entity.entityImpl.Movie;
import org.nightfury.persistence.repository.GenericRepository;
import org.nightfury.persistence.repository.mapper.mapperImpl.MovieMapper;

public class MovieRepositoryImpl extends GenericRepository<Movie> {


    public MovieRepositoryImpl() throws SQLException {
        super(DriverManager.getConnection("jdbc:sqlite:db/Cinema.db"), "movies",
            new MovieMapper());
    }

    @Override
    protected List<String> tableAttributes() {
        return List.of(
            "movie_id", "name", "release_year", "genre", "duration", "director", "description");
    }

    @Override
    protected List<Object> tableValues(Movie entity) {
        return List.of(entity.getId(), entity.getName(), entity.getReleaseYear(), entity.getGenre(),
            entity.getDuration(), entity.getDirector(), entity.getDescription());

    }

    @Override
    protected String additionalQueryArguments() {
        return "";
    }
}
