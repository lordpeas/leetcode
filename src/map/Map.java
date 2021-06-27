package map;

public interface Map<K, V> {

    void put(K key, V value);

    V get(K key);

    void delete(K key);

    int size();
}
