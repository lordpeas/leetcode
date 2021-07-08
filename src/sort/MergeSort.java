package sort;

/**
 * Description: leetcode
 * Created by : Tianqi Cui
 * Create Date: 2021年7月5日 23:55
 */
public class MergeSort {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] res = merge(nums1, nums2);
        int c = res.length;
        if (c % 2 == 0) {
            return ((double) res[c / 2 - 1] + (double) res[c / 2]) / 2;
        } else {
            return res[c / 2];
        }
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int lo = 0, hi = m + n - 1, mid = m - 1;
        int[] aux = new int[m + n];
        int[] res = new int[m + n];
        for (int k = 0; k <= mid; k++) {
            aux[k] = nums1[k];
            res[k] = nums1[k];
        }

        for (int k = 0; k < n; k++) {
            aux[k + mid + 1] = nums2[k];
            res[k + mid + 1] = nums2[k];
        }

        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                res[k] = aux[j++];
            } else if (j > hi) {
                res[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                res[k] = aux[j++];
            } else {
                res[k] = aux[i++];
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        MergeSort sort = new MergeSort();
//        int[] nums1 = new int[]{1, 3};
//        int[] nums2 = new int[]{2};
//        double res = sort.findMedianSortedArrays(nums1, nums2);
//        System.out.println(res);

        double i = (double) 5/(double) 2;
        System.out.println(i);
    }
}
