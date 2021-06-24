package array;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multiply-strings
 * Description: leetcode
 * Created by : Tianqi Cui
 * Create Date: 2021年4月11日 16:40
 */
public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        int[] res = new int[l1 + l2];
        for (int i = l1 - 1; i >= 0; i--) {
            for (int j = l2 - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + res[p2];
                res[p2] = sum % 10;
                res[p1] = sum / 10;
            }

        }


        int i = 0;

        while (i < res.length && res[i] == 0 ) {
            i++;
        }

        StringBuilder sb = new StringBuilder();

        for (int x = i; x < res.length; x++) {
            sb.append(res[x]);
        }
        return sb.length()==0?"0":sb.toString();
    }


    public static void main(String[] args) {
        String multiply = new MultiplyStrings().multiply("123", "456");
        System.out.println(multiply);
    }
}
