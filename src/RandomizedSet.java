import java.util.*;

/**
 * Description: leetcode
 * Created by : Tianqi Cui
 * Create Date: 2021/3/24 20:33
 */
public class RandomizedSet {

    private List<Integer> list;

    private Map<Integer, Integer> map;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        Integer index = map.get(val);
        Integer lastIndex = list.size() - 1;
        swap(list, index, lastIndex);

        map.put(list.get(list.size() - 1), index);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    private void swap(List<Integer> list, Integer index, Integer lastIndex) {
        Integer temp = list.get(index);
        list.set(index, list.get(lastIndex));
        list.set(lastIndex, temp);
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int i = (int) (Math.random() * (list.size()+1));
        System.out.println("random:" + i);
        System.out.println("size:" + list.size());
        System.out.println(i % list.size());
        return list.get(i % list.size());
    }

    //    ["RandomizedSet","insert","remove","insert","getRandom","remove","insert","getRandom"]
//            [[],[1],[2],[2],[],[1],[2],[]]
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(1);
        randomizedSet.remove(2);
        randomizedSet.insert(2);
        int random1 = randomizedSet.getRandom();
        randomizedSet.remove(1);
        randomizedSet.insert(2);
        int random2 = randomizedSet.getRandom();
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
