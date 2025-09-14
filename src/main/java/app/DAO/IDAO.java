package app.DAO;

import java.util.List;

public interface IDAO <T>{

    List<T> findAll();
    T findById(int id);
    T save(T t);
    void delete(T t);
    void Update(T t);
}
