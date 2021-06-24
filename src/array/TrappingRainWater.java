package array;


/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 *
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        int n =height.length;
        int res =0;

        for (int i = 1; i < n-1 ; i++) {
            int lm =Integer.MIN_VALUE;
            int rm = Integer.MIN_VALUE;
            for (int j = i; j < n; j++) {
                 rm = Math.max(rm,height[j]);
            }

            for(int z=i;z>=0;z--){
                lm = Math.max(lm,height[z]);
            }

            if(lm==height[i]&& rm==height[i]){
                continue;
            }
            res+=Math.min(lm,rm)-height[i];
        }
        return res;

    }


    public int trap2(int[] height) {
        int n =height.length;
        int res =0;

        int[]lms=new int[n];
        int[]rms = new int[n];

        for (int i = 1; i < n-1 ; i++) {
            int lm =Integer.MIN_VALUE;
            int rm = Integer.MIN_VALUE;
            for (int j = i; j < n; j++) {
                rm = Math.max(rm,height[j]);
            }

            for(int z=i;z>=0;z--){
                lm = Math.max(lm,height[z]);
            }

            if(lm==height[i]&& rm==height[i]){
                continue;
            }
            res+=Math.min(lm,rm)-height[i];
        }
        return res;

    }
}
