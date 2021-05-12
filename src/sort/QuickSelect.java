package sort;

public class QuickSelect {

    /**
     * 快速选择
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        int lo = 0, hi = nums.length - 1;
        k = nums.length - k;
        while (lo <= hi) {
            int p = new QuickSort().partition(nums, lo, hi); ;
            if (p < k) {
                lo = p + 1;
            } else if (p > k) {
                hi = p - 1;
            }else {
                return nums[p];
            }
        }

        return -1;
    }
}
