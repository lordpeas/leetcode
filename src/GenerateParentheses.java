import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {


    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateAll(new char[2 * n], 0, result);
        return result;
    }


    public void generateAll(char[] current, int pos, List<String> result) {
        if (current.length == pos) {
            result.add(new String(current));
        } else {
            current[pos] = '(';
            if (validPair(current)) {
                generateAll(current, pos + 1, result);
            }
            current[pos] = ')';
            if (validPair(current)) {
                generateAll(current, pos + 1, result);
            }
        }
    }


    private boolean validPair(char[] current) {
        int count = 0;
        int left = 0;
        for (char c : current) {
            if (c == '(') {
                count++;
                left++;
            } else {
                count--;
            }

            if (count < 0) {
                return false;
            }
        }

        if (left > current.length / 2) {
            return false;
        }
        return true;

    }


    public static void main(String[] args) {
        String[] strs = new String[26];

        System.out.println(strs.length);
    }


}
