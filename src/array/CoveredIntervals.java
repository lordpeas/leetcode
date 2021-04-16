package array;


import java.util.Arrays;

/**
 * 给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。
 *
 * 只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。
 *
 * 在完成所有删除操作后，请你返回列表中剩余区间的数目。
 *
 *  
 *
 * 示例：
 *
 * 输入：intervals = [[1,4],[3,6],[2,8]]
 * 输出：2
 * 解释：区间 [3,6] 被区间 [2,8] 覆盖，所以它被删除了。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-covered-intervals
 *
 */
public class CoveredIntervals {

    public int removeCoveredIntervals(int[][] intervals) {
        int res = 0;
        Arrays.sort(intervals,(a,b)->{
            if(a[0]==b[0]){
                return b[1]-a[1];
            }else {
                return a[0]-b[0];
            }
        });

        //生命初始边界
        int left = intervals[0][0];
        int right =intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            //覆盖
            if(left>=intervals[i][0]&&intervals[i][1]<=right){
                res++;
            }
            //相交合并
            if(right>=intervals[i][0]&&right<=intervals[i][1]){
                right=intervals[i][1];
            }

            //完全不相交 更新起点终点
            if(right<intervals[i][0]){
                left=intervals[i][0];
                right=intervals[i][1];
            }
        }
        return intervals.length-res;
    }
}
