package erfen;

import com.sun.xml.internal.org.jvnet.mimepull.CleanUpExecutorFactory;

import java.util.Arrays;

/**
 * Description: leetcode
 * Created by : Tianqi Cui
 * Create Date: 2021年5月29日 00:22
 */
public class BinarySearch {


    public int search(int nums[], int target) {
        int n = nums.length;
        if (n == 0) return -1;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] == target) {
                r = mid - 1;
            }
        }

        if (nums[l] != target | l > n - 1) {
            return -1;
        }

        return l;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 2, 2, 2, 2, 4, 5, 6};
        BinarySearch search = new BinarySearch();
        int res = search.search(nums, 2);
        System.out.println(res);

        int dp[][] = new int[3][3];

    }


    public int splitArray(int[] nums, int m) {
        int len = nums.length;
        // 前缀和，preSum[i] = sum[0..i)
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        // 区间 [i..j] 的和 preSum(j + 1) - preSum(i)
        int[][] dp = new int[len][m + 1];
        // 初始化：由于要找最小值，初值赋值成为一个不可能达到的很大的值
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        // 分割数为 1 ，即不分割的情况，所有的前缀和就是依次的状态值
        for (int i = 0; i < len; i++) {
            dp[i][1] = preSum[i + 1];
        }

        // 从分割数为 2 开始递推
        for (int k = 2; k <= m; k++) {
            // 还未计算出的 i 是从 j 的最小值的下一位开始，因此是 k - 1
            for (int i = k - 1; i < len; i++) {
                // j 表示第 k - 1 个区间的最后一个元素额下标，最小值为 k - 2，最大值为 len - 2（最后一个区间至少有 1 个元素）
                for (int j = k - 2; j < i; j++) {
                    dp[i][k] = Math.min(dp[i][k], Math.max(dp[j][k - 1], preSum[i + 1] - preSum[j + 1]));
                }
            }
        }
        return dp[len - 1][m];
    }

}
