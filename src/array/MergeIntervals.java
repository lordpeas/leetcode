package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 *
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();

        Arrays.sort(intervals,(a, b)->{
            if(a[0]==b[0]){
                return b[1]-a[1];
            }else {
                return a[0]-b[0];
            }
        });

        //生命初始边界
        int left = intervals[0][0];
        int right =intervals[0][1];
        list.add(intervals[0]);
        int[] temp = intervals[0];
        int n = 1;
        for (int i = 1; i < intervals.length; i++) {
            //覆盖
            if(left>=intervals[i][0]&&intervals[i][1]<=right){
                continue;
            }
            //相交合并
            if(right>=intervals[i][0]&&right<=intervals[i][1]){
                right=intervals[i][1];
                temp[1]=intervals[i][1];
                continue;
            }

            //完全不相交 更新起点终点
            if(right<intervals[i][0]){
                left=intervals[i][0];
                right=intervals[i][1];
                list.add(intervals[i]);
                n++;
                temp=intervals[i];
                continue;
            }
        }
        int[][] res = new int[list.size()][2];

        for (int i=0;i<list.size();i++) {
            res[i] = list.get(i);
        }

        return res;
    }


    public int[][] merge2(int[][] intervals) {
        List<int[]> list = new ArrayList<>();

        Arrays.sort(intervals,(a, b)->{
            if(a[0]==b[0]){
                return b[1]-a[1];
            }else {
                return a[0]-b[0];
            }
        });

        list.add(intervals[0]);
        int[] temp = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
          int[] cur =   intervals[i];

            //相交或覆盖
            if(cur[0]<=temp[1]){
                temp[1]=Math.max(temp[1],cur[1]);
            }else {
                list.add(cur);
                temp=cur;
            }
        }
        int[][] res = new int[list.size()][2];

        for (int i=0;i<list.size();i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
