package sort;

import jdk.nashorn.internal.objects.NativeUint8Array;

public class QuickSort {

    public int findKthLargest(int[] nums, int k) {
        sort(nums);
        return nums[nums.length-k];
    }

    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int lo, int hi) {
        if (lo > hi) return;
        int p = partition(nums, lo, hi);
        sort(nums, 0, p - 1);
        sort(nums, p + 1, hi);

    }

    private int partition(int[] nums, int lo, int hi) {
        if (lo == hi) return lo;
        int pivot = nums[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (nums[++i] < pivot) {
                if(i==hi) break;
            }

            while (nums[--j] > pivot){
                if (j==lo) break;
            }
            if(i>=j) break;
            swap(nums,i,j);
        }
        swap(nums,lo,j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
       int[] nums = new int[]{4,1,6,3,2,5};
        int kthLargest = quickSort.findKthLargest(nums, 2);
        System.out.println(kthLargest);

    }
}
