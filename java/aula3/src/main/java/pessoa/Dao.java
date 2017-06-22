package pessoa;

/**
 * @author carloshenrique
 */
public interface Dao<T> {
    
    void insert(T t);

    void update(T t);

    void delete(T t);
    
    T loadBy(Long id);

}
