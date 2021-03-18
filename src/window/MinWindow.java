package window;

import com.sun.media.sound.RIFFInvalidDataException;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: leetcode
 * Created by : Tianqi Cui
 * Create Date: 2021/3/18 21:02
 */
public class MinWindow {


    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        //子串
        int start = 0, len = Integer.MAX_VALUE;

        //窗口
        int left = 0, right = 0;

        int valid = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.get(c) != null) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                char d = s.charAt(left);
                if (need.get(d) != null) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return  len ==Integer.MAX_VALUE?"":s.substring(start,start+len);
    }
}
