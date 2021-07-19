/**
 * Description: leetcode
 * Created by : Tianqi Cui
 * Create Date: 2021年7月19日 16:34
 */
public class Sub {

    public static String sub(String a, String b) {

        int len1 = a.length();
        int len2 = b.length();

        boolean neg = false;
        if (len2 > len1) {
            neg = true;
        } else if (len2 == len1) {
            int pt = 0;
            while (pt < len1 - 1) {
                if ((a.charAt(pt) - '0') < (b.charAt(pt) - '0')) {
                    neg = true;
                    break;
                }
                pt++;
            }
        }

        StringBuilder sd = new StringBuilder();


        if (neg) {
            String temp = "";
            temp = a;
            a = b;
            b = temp;

            len1 = a.length();
            len2 = b.length();
        }

        int carry = 0;

        int p1 = len1 - 1;
        int p2 = len2 - 1;


        while (p1 >= 0 || p2 >= 0) {
            int num1 = 0;
            if (p1 >= 0) {
                num1 = a.charAt(p1--) - '0';
            }

            int num2 = 0;
            if (p2 >= 0) {
                num2 = b.charAt(p2--) - '0';
            }

            int bitValue = num1 - carry - num2;
            if (num1 < num2) {
                carry = 1;
            }

            sd.append(bitValue);
        }

       if(neg){
           sd.append("-");
       }
       return sd.reverse().toString();
    }


    public static void main(String[] args) {
      String res =   sub("12","3412");
      System.out.println(res);
    }
}
