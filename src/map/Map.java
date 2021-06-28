package map;

public interface Map<K, V> {

    void put(K key, V value);

    V get(K key);

    void delete(K key);

    int size();

    default boolean contains(K key) {
        return get(key) != null;
    }

    default boolean isEmpty() {
        return size() == 0;
    }
}
