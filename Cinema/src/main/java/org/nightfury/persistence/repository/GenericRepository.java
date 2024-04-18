package org.nightfury.persistence.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.nightfury.persistence.entity.GenericEntity;
import org.nightfury.persistence.repository.exception.AlreadyExistsException;
import org.nightfury.persistence.repository.mapper.RowMapper;

public abstract class GenericRepository<T extends GenericEntity> implements Repository<T> {

    protected Connection connection;
    private String tableName;
    private RowMapper<T> rowMapper;

    public GenericRepository(Connection connection, String tableName, RowMapper<T> rowMapper) {
        this.tableName = tableName;
        this.connection = connection;
        this.rowMapper = rowMapper;
    }

    @Override
    public T save(T entity) throws SQLException, AlreadyExistsException {
        List<Object> values = tableValues(entity);
        if (!existsById(entity.getId())) {
            return insert(values);
        } else {
            throw new AlreadyExistsException("Такий запис уже існує!");
        }

    }

    public int getRowCount() {
        String sql = "SELECT COUNT(" + tableAttributes().get(0) + ") AS kilkist FROM " + tableName;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            return resultSet.getInt("kilkist");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private T insert(List<Object> values) throws SQLException {
        List<String> attributes = tableAttributes();
        String attributesString = String.join(", ", attributes);
        String placeholders = Stream.generate(() -> "?").limit(attributes.size())
            .collect(Collectors.joining(", "));
        String sql =
            "INSERT INTO " + tableName + " (" + attributesString + ") VALUES (" + placeholders
                + ")";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            int index = 2;
            for (Object value : values) {
                preparedStatement.setObject(index, value);
                index++;
            }
            preparedStatement.executeUpdate();
            return findByID(getLastRecordId());
        }
    }

    private int getLastRecordId() throws SQLException {
        String sql = "SELECT * FROM " + tableName + " ORDER BY " + tableAttributes().get(0) + " DESC LIMIT 1";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            return resultSet.getInt(tableAttributes().get(0));
        }
    }

    private boolean existsById(int id) throws SQLException {
        String sql = "SELECT * FROM " + tableName + " WHERE " + tableAttributes().get(0) + " = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setObject(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next() && resultSet.getInt(1) > 0;
            }
        }
    }

    @Override
    public List<T> findAll() throws SQLException {
        List<T> list = new ArrayList<>();
        String sql = "SELECT * FROM " + tableName + " " + additionalQueryArguments();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    list.add(rowMapper.mapRow(resultSet));
                }
            }
        }
        return list;
    }

    @Override
    public T findByID(int id) throws SQLException {
        String sql = "SELECT * FROM " + tableName + " " + additionalQueryArguments() + " WHERE " + tableAttributes().get(0) + " = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return rowMapper.mapRow(resultSet);
                } else {
                    return null;
                }
            }
        }
    }

    @Override
    public T findByName(String name) throws SQLException {
        String sql = "SELECT * FROM " + tableName + " " + additionalQueryArguments() + " WHERE name = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return rowMapper.mapRow(resultSet);
                } else {
                    return null;
                }
            }
        }
    }

    @Override
    public int delete(int id) throws SQLException {
        String sql = "DELETE FROM " + tableName + " WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
        return id;
    }

    protected abstract List<String> tableAttributes();

    protected abstract List<Object> tableValues(T entity);

    protected abstract String additionalQueryArguments();
}
