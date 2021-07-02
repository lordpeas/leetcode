package d;

/**
 * Description: leetcode
 * Created by : Tianqi Cui
 * Create Date: 2021年6月30日 23:01
 */
public class Palindrom {

    public String longestPalindrome(String s) {
        String res = "";
        int n = s.length();
        for (int i = 0; i < n - 1; i++) {
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i + 1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    private String palindrome(String s, int i, int j) {

        while ((i >= 0 && j <= s.length() - 1) && (s.charAt(i) == s.charAt(j))) {
            i--;
            j++;
        }
        return s.substring(i+1, j );
    }

    public static void main(String[] args) {
        Palindrom palindrom = new Palindrom();
        String s = palindrom.longestPalindrome("babad");
        System.out.println(s);
    }
}
