package dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: leetcode
 * Created by : Tianqi Cui
 * Create Date: 2021年6月28日 23:44
 */
public class Permutations {

    private  List<List<Integer>>  res= new ArrayList<>() ;


    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> trace = new LinkedList<>();
        backTrace(nums,trace);
        return res;
    }

    public void backTrace(int[] nums,LinkedList<Integer> trace){
        if(trace.size()==nums.length){
            res.add(new LinkedList<Integer>(trace));
            return;
        }

        for(int i = 0;i<=nums.length-1;i++){
            if(trace.contains(nums[i])){
                continue;
            }

            trace.add(nums[i]);
            backTrace(nums,trace);
            trace.removeLast();
        }
    }


    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        int[] nums = new int[]{1,2};
        List<List<Integer>> res = permutations.permute(nums);
        System.out.println(res);
    }
}
