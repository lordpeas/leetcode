/**
 * Description: leetcode
 * Created by : Tianqi Cui
 * Create Date: 2021年3月14日 22:40
 */
public class BinarySearch {
    public int shipWithinDays(int[] weights, int D) {
        int left = getMax(weights) ,right = getSum(weights);
        while(left<=right){
            int mid =left+(right-left)/2;
            if(canFinish(weights,mid,D)){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return left;
    }


    private boolean canFinish(int[] weights,int power,int D){

        int time = 0;
        int total = 0;
        for(int i = 0;i<=weights.length-1;i++){
            total = total+weights[i];
            if(total>power){
                time++;
                total = weights[i];
            }
        }

        return time+1<=D;
    }


    private int getMax(int[] weights){
        int max= Integer.MIN_VALUE;
        for(int i = 0;i<=weights.length-1;i++){
            max= Math.max(weights[i],max);
        }
        return max;
    }

    private int getSum(int[] weights){
        int total=0;
        for(int i = 0;i<=weights.length-1;i++){
            total+=weights[i] ;
        }
        return total;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int i = binarySearch.shipWithinDays(new int[]{1}, 1);
        System.out.println(i);
    }
}
