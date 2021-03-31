package LRU;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache2 {

    private Map<Integer,Integer> cache;
    private int capacity;
    public LRUCache2(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<>();
    }

    public int get(int key) {
        Integer value = cache.get(key);
        if(value == null) return -1;
        cache.remove(key);
        cache.put(key,value);
        return value;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.remove(key);
            cache.put(key,value);
            return;
        }

        if(cache.size()>= capacity){
            Integer next = cache.keySet().iterator().next();
            cache.remove(next);
        }
        cache.put(key,value);
    }
}
