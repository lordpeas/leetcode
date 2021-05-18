package array;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Description: leetcode
 * Created by : Tianqi Cui
 * Create Date: 2021/3/25 20:59
 */
public class RandomPickWithBlackList {

    private int size;

    private Map<Integer, Integer> map = new HashMap<>();

    public RandomPickWithBlackList(int N, int[] blacklist) {

        size = N - blacklist.length;

        for (int b : blacklist) {
            map.put(b, b);
        }

        int last = N - 1;

        for (int b : blacklist) {
            if(b>=size){
                continue;
            }
            while (map.get(last) != null) {
                last--;
            }

            map.put(b, last);
            last--;
        }
    }

    public int pick() {
        int val = (int) (Math.random() * size);

        if (map.get(val) != null) {
            return map.get(val);
        }

        return val;
    }
}
