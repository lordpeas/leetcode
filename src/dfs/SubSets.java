package dfs;

import com.sun.org.apache.bcel.internal.generic.FSUB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: leetcode
 * Created by : Tianqi Cui
 * Create Date: 2021年6月27日 23:44
 */
public class SubSets {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        LinkedList<Integer> trace = new LinkedList<>();
        res.add(new ArrayList<>(trace));
        traceBack(nums, trace, 0);
        return res;
    }

    private void traceBack(int[] nums, LinkedList<Integer> trace, int i) {
        for (int j = i; j <= nums.length - 1; j++) {
            if (trace.contains(nums[j])) {
                continue;
            }
            trace.add(nums[j]);
            res.add(new ArrayList<>(trace));
            traceBack(nums, trace, j+1);
            trace.removeLast();
        }
    }

    public static void main(String[] args) {
        SubSets sets = new SubSets();
        int[] nums = new int[]{1, 2,3};
        List<List<Integer>> list = sets.subsets(nums);
        System.out.println(list);
    }
}
