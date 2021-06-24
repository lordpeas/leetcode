import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Description: leetcode
 * Created by : Tianqi Cui
 * Create Date: 2021年4月18日 19:02
 */
public class ValidParentheses {

    public boolean isValid(String s) {

        if (null == s || "".equals(s)) return false;

        LinkedList<Character> queue = new LinkedList<>();
        Map<Character, Character> itemMap = getItemMap();

        for (int i = 0; i <= s.length() - 1; i++) {
            char item = s.charAt(i);
            if (item == '(' || item == '{' || item == '[') {
                queue.push(s.charAt(i));
            } else {
                if (!queue.isEmpty()) {
                    Character pop = queue.pop();
                    if (itemMap.get(item) != pop) {
                        return false;
                    }
                } else {
                    return false;
                }

            }
        }

        return queue.size() == 0;
    }


    private Map<Character, Character> getItemMap() {
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
        return map;
    }

}
