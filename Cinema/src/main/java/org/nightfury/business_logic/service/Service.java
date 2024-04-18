package org.nightfury.business_logic.service;

import java.sql.SQLException;
import java.util.List;
import org.nightfury.persistence.repository.exception.AlreadyExistsException;

public interface Service<T> {
    T save(T entity) throws SQLException, AlreadyExistsException;

    List<T> findAll() throws SQLException;

    T findByID(int id) throws SQLException;

    T findByName(String name) throws SQLException;

    int delete(int id) throws SQLException;
}

