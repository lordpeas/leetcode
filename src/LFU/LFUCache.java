package LFU;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * Description: leetcode
 * Created by : Tianqi Cui
 * Create Date: 2021年2月28日 20:06
 */
public class LFUCache {
    private Map<Integer,Integer> keyToVal;
    private Map<Integer,Integer> keyToFre;
    private Map<Integer, LinkedHashSet<Integer>> freqToKey;
    private int minFreq;
    private int capacity;
    public LFUCache(int capacity) {
        this.keyToVal = new HashMap<>();
        this.keyToFre = new HashMap<>();
        this.freqToKey = new HashMap<>();
        this.capacity = capacity;
        this.minFreq = 0;
    }

    public int get(int key) {
        Integer value =  keyToVal.get(key);
        if(value != null){
            increaseFre(key);
            return value;
        }else{
            return -1;
        }
    }




    public void put(int key, int value) {
        if(keyToVal.containsKey(key)){
            keyToVal.put(key,value);
            increaseFre(key);
            return;
        }

        if(this.capacity<=keyToVal.size()){
            removeMinFreqKey();
        }

        keyToVal.put(key,value);
        keyToFre.put(key,1);
        freqToKey.putIfAbsent(1,new LinkedHashSet<>());
        freqToKey.get(1).add(key);
        this.minFreq = 1;
    }

    private void increaseFre(int key){
        Integer freq =  keyToFre.get(key);
        int f = 1;
        if(null == freq){
            keyToFre.put(key,1);
        }else{
            keyToFre.put(key,freq + 1);
            f = freq+1;
            freqToKey.get(freq).remove(key);
        }

        if(freqToKey.get(freq).isEmpty()){
            freqToKey.remove(freq);
            if(freq == this.minFreq){
                this.minFreq =f;
            }
        }
        freqToKey.putIfAbsent(f,new LinkedHashSet<>());
        freqToKey.get(f).add(key);
    }


    private void removeMinFreqKey(){
        LinkedHashSet<Integer> keyList = freqToKey.get(this.minFreq);
        int deleteKey =  keyList.iterator().next();
        keyList.remove(deleteKey);
        if(keyList.isEmpty()){
            freqToKey.remove(this.minFreq);
        }

        keyToVal.remove(deleteKey);
        keyToFre.remove(deleteKey);
    }
}
