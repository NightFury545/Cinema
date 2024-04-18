package org.nightfury.business_logic.service;

import java.sql.SQLException;
import java.util.List;
import org.nightfury.persistence.entity.GenericEntity;
import org.nightfury.persistence.repository.GenericRepository;
import org.nightfury.persistence.repository.exception.AlreadyExistsException;

public abstract class GenericService<T extends GenericEntity> implements Service<T> {

    protected final GenericRepository<T> genericRepository;

    public GenericService(GenericRepository<T> genericRepository) {
        this.genericRepository = genericRepository;
    }

    @Override
    public T save(T entity) {
        try {
            return genericRepository.save(entity);
        } catch (SQLException | AlreadyExistsException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<T> findAll() {
        try {
            return genericRepository.findAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public T findByID(int id) {
        try {
            return genericRepository.findByID(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int delete(int id) {
        try {
            return genericRepository.delete(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public T findByName(String name) {
        try {
            return genericRepository.findByName(name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
