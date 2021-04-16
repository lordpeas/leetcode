package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个由一些 闭区间 组成的列表，firstList 和 secondList ，其中 firstList[i] = [starti, endi] 而 secondList[j] = [startj, endj] 。每个区间列表都是成对 不相交 的，并且 已经排序 。
 * <p>
 * 返回这 两个区间列表的交集 。
 * <p>
 * 形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b 。
 * <p>
 * 两个闭区间的 交集 是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3] 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
 * 输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * 示例 2：
 * <p>
 * 输入：firstList = [[1,3],[5,9]], secondList = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：firstList = [], secondList = [[4,8],[10,12]]
 * 输出：[]
 * 示例 4：
 * <p>
 * 输入：firstList = [[1,7]], secondList = [[3,10]]
 * 输出：[[3,7]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/interval-list-intersections
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntervalListIIntersections {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        List<int[]> list = new ArrayList<>();

        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
         int [] a =   firstList[i];
         int [] b =  secondList[j];
            if(a[1]>=b[0] && a[0]<=b[1]){
                list.add(new int[]{Math.max(a[0],b[0]),Math.min(a[1],b[1])});
            }

            if(a[1]>b[1]){
                j++;
            }else {
                i++;
            }
        }
        int[][] res = new int[list.size()][2];

        for (int n=0;i<list.size();n++) {
            res[n] = list.get(n);
        }

        return res;
    }
}
