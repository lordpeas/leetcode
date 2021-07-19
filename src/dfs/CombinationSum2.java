package dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: leetcode
 * Created by : Tianqi Cui
 * Create Date: 2021年7月15日 20:51
 */
public class CombinationSum2 {

        public ArrayList<ArrayList<Integer>> combinationSum(int[] num, int target) {
            int n = num.length;
            ArrayList<ArrayList<Integer>>  res = new ArrayList<>();
            if (n == 0 || target < 0) return res;


            LinkedList<Integer> trace = new LinkedList<>();
            traceBack(num, res, trace, target);
            return res;
        }


        public void traceBack(int[] num, ArrayList<ArrayList<Integer>> res, LinkedList<Integer> trace, int target) {
            if (target < 0) {
                return;
            }

            if (target == 0) {
                res.add(new ArrayList<Integer>(trace));
            }

            for (int i = target; i <= num.length - 1; i++) {
                if (i > target && num[i] == num[i - 1]) {
                    continue;
                }

                trace.offer(num[i]);
                traceBack(num, res, trace, target - num[i]);
                trace.poll();
            }
            return;
        }
}
