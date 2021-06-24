package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     * <p>
     * 注意：答案中不可以包含重复的三元组。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     * 示例 2：
     * <p>
     * 输入：nums = []
     * 输出：[]
     * 示例 3：
     * <p>
     * 输入：nums = [0]
     * 输出：[]
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int target =  - nums[i];
            int base = nums[i];
            List<List<Integer>> lists = twoSum(nums, i + 1, target);
            for (List<Integer> list :lists) {
                list.add(nums[i]);
                res.add(list);
            }
            // 跳过第一个数字重复的情况，否则会出现重复结果
            //while (i < nums.length  && nums[i] == base ) i++;
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
        }
        return res;
    }

    private List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int end = nums.length - 1;
        while (start <= end) {
            int left = nums[start], right = nums[end];
            int sum = left + right;
            if (sum < target) {
                while (start <= end && nums[start] == left) {
                    start++;
                }
            } else if (sum > target) {
                while (start <= end && right == nums[end]) {
                    end--;
                }
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(nums[start]);
                list.add(nums[end]);
                res.add(list);
                while (start <= end && nums[start] == left) start++;
                while (start <= end && right == nums[end]) end--;
            }
        }
        System.out.println("hahha");
        return res;
    }

}
