package sort;

import jdk.nashorn.internal.objects.NativeUint8Array;

public class QuickSort {

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
            while (nums[++i] > pivot) {
                if(i==hi) break;
            }

            while (nums[--j]<pivot){
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
       quickSort.sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }

    }
}
