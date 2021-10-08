package dao;

import java.util.List;

public interface IGeneralDao<T> {

    List<T> getAll();

    boolean save(T t);

    boolean edit(int id, T t);

    boolean delete(int id);

    T getById(int id);

}
