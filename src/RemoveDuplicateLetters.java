import java.util.*;

/**
 * Description: leetcode
 * Created by : Tianqi Cui
 * Create Date: 2021年3月28日 19:53
 */
public class RemoveDuplicateLetters {

    String removeDuplicateLetters(String s) {

        Stack<Character> stk = new Stack<>();

        // 维护一个计数器记录字符串中字符的数量
        // 因为输入为 ASCII 字符，大小 256 够用了
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }

        boolean[] inStack = new boolean[256];
        for (char c : s.toCharArray()) {
            // 每遍历过一个字符，都将对应的计数减一
            count[c]--;

            if (inStack[c]) continue;

            while (!stk.isEmpty() && stk.peek() > c) {
                // 若之后不存在栈顶元素了，则停止 pop
                if (count[stk.peek()] == 0) {
                    break;
                }
                // 若之后还有，则可以 pop
                inStack[stk.pop()] = false;
            }
            stk.push(c);
            inStack[c] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stk.empty()) {
            sb.append(stk.pop());
        }
        return sb.reverse().

                toString();
    }


    public String removeDuplicateLetters1(String s) {
        Map<Character, Integer> count = new HashMap<>();
        LinkedList<Character> stack = new LinkedList<>();
        boolean[] inStack = new boolean[256];
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        for (char c : s.toCharArray()) {
            count.put(c, count.get(c) - 1);
            if (inStack[c]) {
                continue;
            }

            while (!stack.isEmpty() && stack.peek()> c) {
                if (count.get(stack.peek()) == 0) {
                    break;
                }
                inStack[stack.pop()] = false;
            }
            stack.push(c);
            inStack[c] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
