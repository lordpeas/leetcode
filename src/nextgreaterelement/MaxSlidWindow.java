package nextgreaterelement;

import javafx.scene.layout.Priority;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Description: leetcode
 * Created by : Tianqi Cui
 * Create Date: 2021/3/5 19:52
 */
public class MaxSlidWindow{

        public int[] maxSlidingWindow(int[] nums, int k) {
            PriorityQueue<Integer> q = new PriorityQueue<Integer>((a, b)->b-a);
            int[] res = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if(i<k-1){
                    q.offer(nums[i]);
                }else {
                    q.offer(nums[i]);
                    res[i] = q.peek();
                    q.remove(nums[i-k]);
                }
            }
            return res;
        }


        public int[] maxSlidingWindow2(int[] nums, int k) {
            List<Integer> list = new ArrayList<>();
            MonotonicQueue q =  new MonotonicQueue();
            for(int i = 0; i< nums.length; i++){
                if(i<k-1){
                    q.push(nums[i]);
                }else{
                    q.push(nums[i]);
                    list.add(q.getMax());
                    q.pop(nums[i-k+1]);
                }
            }


            // 需要转成 int[] 数组再返回
            int[] arr = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                arr[i] = list.get(i);
            }
            return arr;

        }


        class MonotonicQueue{
            LinkedList<Integer> ls = new LinkedList<>();

            public void push(int x){
                while(!ls.isEmpty()&& x>ls.getLast()){
                    ls.pollLast();
                }
                ls.addLast(x);
            }

            public int getMax(){
                return ls.getFirst();
            }

            public void pop(int x){
                if (x == ls.getFirst()) {
                    ls.pollFirst();
                }
            }
        }
}


