package fr.eni.lesencheres.dal;

import java.util.List;

public interface GenericDAO<T> {
	T getById(int id);
    List<T> getAll();
    void create(T entity);
    void update(T entity);
    void delete(int id);

}
