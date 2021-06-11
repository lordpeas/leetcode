import java.util.Arrays;
import java.util.Comparator;

/**
 * Description: leetcode
 * Created by : Tianqi Cui
 * Create Date: 2021年5月31日 23:57
 */
public class IntervalSchedule {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int count = 0;
        int end = intervals[0][1];
        for (int i = 1; i <= intervals.length-1; i++) {
            int start = intervals[i][0];
            if (start >= end) {
                end = intervals[i][1];
            } else {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int[][] ints = new int[4][2];
        ints[0] = new int[]{1, 2};
        ints[1] = new int[]{2, 3};
        ints[2] = new int[]{3, 4};
        ints[3] = new int[]{1, 3};
        int i = new IntervalSchedule().eraseOverlapIntervals(ints);
        System.out.println(i);
    }
}
