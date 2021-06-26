package pc;

import sun.misc.Queue;

import java.util.LinkedList;

/**
 * Description: leetcode
 * Created by : Tianqi Cui
 * Create Date: 2021/6/3 17:53
 */
public class Container {

    private LinkedList<Integer> queue;
    private Integer capicity;

    public Container(LinkedList<Integer> queue, Integer capicity) {
        this.queue = queue;
        this.capicity = capicity;
    }

//    public void put(Integer item) {
//        synchronized (this) {
//            while (queue.size() == capicity) {
//                System.out.println("满了");
//                try {
//                    wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            queue.offer(item);
//            System.out.println("继续添加");
//            notifyAll();
//        }
//    }
//
    public Integer take1() {

        Integer val = 0;
        synchronized (this) {
            while (queue.size() == 0) {
                System.out.println("空了");
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            val = queue.pop();
            notifyAll();
        }
        return val;
//
    }


    public Integer take() {
        Integer val = 0;
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                //如果容器中没有数据，consumer处于等待状态
                while (queue.size() == 0) {
                    System.out.println("container is empty,waiting ...");
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //如果有数据，继续consume
                val = queue.removeFirst();
                System.out.println("consumer--" + Thread.currentThread().getName() + "--take:" + val);
                //唤醒其他所有处于wait()的线程，包括消费者和生产者
                //notify必须放在同步代码块里面
                notifyAll();
            }
            return val;
        }

    }







}
