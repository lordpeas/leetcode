package array;

import java.lang.annotation.ElementType;
import java.util.Arrays;

public class TargetAdd {

    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {


        Arrays.sort(nums);
        int l = 0,r = nums.length-1;
        while (l<=r){
            int sum = nums[l]+nums[r];
            if (sum>target){
                r--;
            }else if (sum<target){
                l++;
            }else{
                return new int[]{l,r};
            }
        }
        return null;
    }
}
