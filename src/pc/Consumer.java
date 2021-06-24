package pc;

import java.util.concurrent.ArrayBlockingQueue;

public class Consumer implements Runnable {

    private ArrayBlockingQueue<Integer> queue;

    public Consumer(ArrayBlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
                if (queue.size() == 0) {
                    System.out.println(Thread.currentThread().getName()+" take blocing");
                }
                Integer take = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
        Thread producer1 = new Thread(new Producer(queue));
        Thread producer2 = new Thread(new Producer(queue));
        Thread producer3 = new Thread(new Producer(queue));
        Thread producer4 = new Thread(new Producer(queue));
        Thread producer5 = new Thread(new Producer(queue));
        producer1.start();
        producer2.start();
        producer3.start();
        producer4.start();
        producer5.start();
        Thread consumer1 = new Thread(new Consumer(queue));
        Thread consumer2 = new Thread(new Consumer(queue));
        consumer1.start();
        consumer2.start();
//        try {
//            producer1.join();
//            producer2.join();
//            producer3.join();
//            producer4.join();
//            producer5.join();
//            consumer1.join();
//            consumer2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }
}
