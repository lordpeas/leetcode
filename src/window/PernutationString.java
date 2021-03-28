package window;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: leetcode
 * Created by : Tianqi Cui
 * Create Date: 2021/3/22 21:04
 */
public class PernutationString {

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();

        int left = 0, right = 0;
        int valid = 0;
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (need.get(c) != null) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            while (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }

                char d = s2.charAt(left);
                left++;
                if (need.get(d) != null) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return false;
    }
}
