package seminar03.repo;

import java.util.Collection;

public interface Repository<T, IId> {

    int add(T item);

    int update(T item);

    int delete(IId id);

    T get(IId id);

    Collection<T> getAll();

}
