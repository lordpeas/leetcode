package array;

import java.util.LinkedList;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * Description: leetcode
 * Created by : Tianqi Cui
 * Create Date: 2021年7月12日 23:09
 */
public class Kth {

    public int findKthNumber(int n, int k) {
        PriorityQueue<String> queue = new PriorityQueue<>();
        int tempInex = n - k + 1;
        for (int i = 1; i <= n; i++) {
            if(queue.size()>=tempInex){
                queue.poll();
            }
            queue.offer(i + "");
        }

//        while(!queue.isEmpty()){
//            System.out.println(queue.poll());
//        }
            return Integer.parseInt(Objects.requireNonNull(queue.poll()));
    }

    public static void main(String[] args) {
        Kth kth = new Kth();
        int number = kth.findKthNumber(10, 3);
        System.out.println(number);
    }
}
