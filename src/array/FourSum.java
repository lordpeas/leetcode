package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {


    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n =4;
      return  nSum(nums,0,target,n);
    }


    private List<List<Integer>> nSum(int[] nums,int start,int target,int n){
        int sz = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        // 至少是 2Sum，且数组大小不应该小于 n
        if (n < 2 || sz < n) return res;
        // 2Sum 是 base case

        int end = nums.length - 1;
        if (n == 2) {
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
            return res;
        }else {
            //n>2
            for (int i = 0; i < nums.length; i++) {
                int sum =target-nums[i];
                List<List<Integer>> lists = this.nSum(nums, i + 1, sum, n - 1);
                for (List<Integer> list:lists ){
                        list.add(nums[i]);
                        res.add(list);
                    }
                    // 跳过第一个数字重复的情况，否则会出现重复结果
                    //while (i < nums.length  && nums[i] == base ) i++;
                    while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
            }
            return res;
        }
    }
}
