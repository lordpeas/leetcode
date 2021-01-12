/**
 * 回文子串
 *  只考虑字母 数字 不考虑大小写
 */
public class ValidPalinDrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.equals("")) {
            return true;
        }

        int l = 0;
        int r = s.length() - 1;


        while (l < r) {

            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }

            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }

            if (l < r) {
                if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                    return false;
                }
                l++;
                r--;
            }
        }

        return true;

    }


    public static void main(String[] args) {


        String str = "Marge, let's \\\"[went].\\\" I await {news} telegram.";
        boolean result = new ValidPalinDrome().isPalindrome(str);
        System.out.println(result);
    }
}
