package LRU;

import java.util.Arrays;

/**
 * Description: leetcode
 * Created by : Tianqi Cui
 * Create Date: 2021/5/18 19:15
 */
public class SolutionMinimumD {

    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        //dp[i][i] 定义为 删除字符串 s1[0...i],s2[0...j]的最小和
        int[][] dp = new int[m+1][n+1];

        dp[0][0] = 0;

        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i-1][0] + s1.charAt(i - 1);
        }

        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j-1] + s2.charAt(j - 1);
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                    System.out.println("case1:" + dp[j][i]);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i - 1), dp[i][j - 1] + s2.charAt(j - 1));
                    System.out.println("case2:" + dp[i][j]);
                }
            }
        }

        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }

        return dp[m][n];

    }



    public int minimumDeleteSum1(String s1, String s2) {
        int ans[][]=new int[s1.length()+1][s2.length()+1];
        for(int i=1;i<=s1.length();i++){
            ans[i][0]=ans[i-1][0]+s1.charAt(i-1);
        }
        for(int j=1;j<=s2.length();j++){
            ans[0][j]=ans[0][j-1]+s2.charAt(j-1);
        }
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                ans[i][j]=s1.charAt(i-1)==s2.charAt(j-1)?ans[i-1][j-1]:Math.min(ans[i-1][j]+s1.charAt(i-1),ans[i][j-1]+s2.charAt(j-1));
            }
        }

        for (int[] ints : ans) {
            System.out.println(Arrays.toString(ints));
        }

        return ans[s1.length()][s2.length()];
    }


    public static void main(String[] args) {
        String s1 = "sea", s2 = "eat";
        SolutionMinimumD solution = new SolutionMinimumD();
        int i = solution.minimumDeleteSum(s1, s2);
        System.out.println(i);
    }
}
