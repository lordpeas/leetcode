package sort;


public class QuickSort2 {



    private void sort(int [] nums){
        sort(nums,0,nums.length-1);
    }

    private void sort(int[] nums,int lo,int hi){
        if(hi<=lo) return;
        int p = partition(nums,lo,hi);
        sort(nums,0,p-1);
        sort(nums,p+1,hi);
    }

    private int partition(int nums[],int lo,int hi){
        if(hi==lo) return lo;
        int i =lo,j = hi+1;
        int p =nums[lo];
        while(true){
            while(nums[++i]<p){
                if(i==hi) break;
            }

            while(nums[--j]>p){
                if(j==lo) break;
            }

            if(j<=i) break;

            exch(nums,i,j);
        }
        exch(nums,j,lo);
        return j;
    }

    private void exch(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j]= temp;
    }


    public static void main(String[] args) {
      int[] nums =   new int[]{4,45,3,12,465,6,23,56,2};
      new QuickSort2().sort(nums);
        System.out.println(nums);
    }

}
