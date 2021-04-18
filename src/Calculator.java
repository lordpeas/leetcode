import java.util.LinkedList;

/**
 * 面试题 16.26. 计算器
 * 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
 * <p>
 * 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "3+2*2"
 * 输出: 7
 * 示例 2:
 * <p>
 * 输入: " 3/2 "
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: " 3+5 / 2 "
 * 输出: 5
 * 说明：
 * <p>
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 * <p>
 * Description: leetcode  https://leetcode-cn.com/problems/calculator-lcci/
 * Created by : Tianqi Cui
 * Create Date: 2021年4月11   日 19:13
 */
public class Calculator {


    public int calculate(String s) {
        LinkedList<Integer> list = new LinkedList<>();
        char sign = '+';

        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isDigit(c)) {
                num = toInt(c, num);
            }

            if(c=='('){
                num = calculate(s.substring(i+1));
            }
            //遇到下一个符号
            if ((!isDigit(c) && c != ' ') || (i == s.length() - 1)) {
                //上一个符号
                int pre;
                switch (sign) {

                    case '+':
                        list.push(num);
                        break;
                    case '-':
                        list.push(-num);
                        break;
                    case '*':
                        pre = list.getFirst();
                        list.pop();
                        list.push(pre * num);
                        break;
                    case '/':
                        pre = list.getFirst();
                        list.pop();
                        list.push(pre / num);
                        break;

                }

                sign = c;
                num = 0;
            }
            if(c == ')')break;
        }

        return sum(list);
    }

    /**
     * 判断是否是数字
     *
     * @param c
     * @return
     */
    private boolean isDigit(char c) {
        if (c < '0' || c > '9') {
            return false;
        }
        return true;
    }


    private int toInt(char c, int num) {
        return 10 * num + (c - '0');
    }


    private int sum(LinkedList<Integer> list) {
        int res = 0;
        while (!list.isEmpty()) {
            res += list.pop();
        }
        return res;
    }


    public static void main(String[] args) {
        String s ="3*2";
        int calculate = new Calculator().calculate(s);
        System.out.println(calculate);
    }


}
