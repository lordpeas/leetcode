import java.util.PriorityQueue;

/**
 * Description: leetcode
 * Created by : Tianqi Cui
 * Create Date: 2021/3/1 20:51
 */
public class MadianFinder {

    /**
     * 梯形 小顶堆
     */
    private PriorityQueue<Integer> large;

    /**
     * 倒三角形 大顶堆
     */
    private PriorityQueue<Integer> small;

    public MadianFinder() {
        //每次取最小元素
        this.large = new PriorityQueue<>();
        //每次取最大元素
        this.small = new PriorityQueue<>((a,b)-> b-a);
    }

    public double findMedian(){
        //如果元素不一样多，多的那个堆顶的堆顶元素就是中位数
        if(large.size()<small.size()){
            return small.peek();
        }else if(large.size()>small.size()){
            return large.peek();
        }

        return ((large.peek()+small.peek())/2.0);
    }


    public void addNum(int num){
        if(small.size()>= large.size()){
            //给large
            small.offer(num);
            large.offer(small.poll());
        }else {
            //给small
            large.offer(num);
            small.offer(large.poll());
        }
    }

}
