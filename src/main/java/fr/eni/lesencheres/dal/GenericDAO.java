package fr.eni.lesencheres.dal;

import java.sql.SQLException;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

public interface GenericDAO<T> {
	T getById(int id);
    List<T> getAll();
    void create(T entity) throws SQLException;
    void update(T entity);
    void delete(int id);

}
