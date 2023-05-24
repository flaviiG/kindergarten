package Repositories;

public interface CRUDRepository<T> {

    boolean add(T entity);

    T[] getAll();
    boolean update(String id, T a);
    boolean delete(String a);

}
