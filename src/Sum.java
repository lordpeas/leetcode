import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: leetcode
 * Created by : Tianqi Cui
 * Create Date: 2021年7月19日 22:41
 */
public class Sum {


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res  = new ArrayList<>();
        int n = nums.length;
        if(n<3){
            return res;
        }
        Arrays.sort(nums);
        for(int i = 0;i<n;i++){
            int target = -nums[i];
            List<List<Integer>> tuples = twoSum(nums,i+1, target);
            for(List<Integer> list :tuples){
                list.add(nums[i]);
                res.add(list);
            }
        }
        return res;
    }


    public List<List<Integer>> twoSum(int [] nums,int start,int target){
        int l = start;
        int r = nums.length-1;
        List<List<Integer>> res = new ArrayList<>();
        while(l<=r){
            int left = nums[l];
            int right = nums[r];
            int mid =nums[l]+nums[r];
            if(mid < target){
                while(l<=r&&nums[l] ==left){
                    l++;
                }
            }else if(mid > target){
                while(l<=r&&nums[r] ==right){
                    r--;
                }
            }else{
                List<Integer> list =  new ArrayList();
                list.add(left);
                list.add(right);
                res.add(list);
                while(l<=r&&nums[l] ==left){
                    l++;
                }

                while(l<=r&&nums[r] ==right){
                    r--;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Sum sum = new Sum();
        List<List<Integer>> list = sum.threeSum(new int[]{1, -1, 0});
        System.out.println(list);
    }
}
