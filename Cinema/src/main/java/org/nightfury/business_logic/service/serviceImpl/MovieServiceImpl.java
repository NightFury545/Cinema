package org.nightfury.business_logic.service.serviceImpl;

import java.sql.SQLException;
import org.nightfury.business_logic.service.GenericService;
import org.nightfury.persistence.entity.entityImpl.Movie;
import org.nightfury.persistence.repository.repositoryImpl.MovieRepositoryImpl;

public class MovieServiceImpl extends GenericService<Movie> {

    public MovieServiceImpl() throws SQLException {
        super(new MovieRepositoryImpl());
    }
}
