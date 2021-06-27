package map;

import java.util.PriorityQueue;

public interface SortedMap<K extends Comparable<K>, V> extends Map<K, V> {

    void deleteMin();

    void deleteMax();

    K min();

    K max();


}
