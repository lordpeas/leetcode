package pc;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Description: leetcode
 * Created by : Tianqi Cui
 * Create Date: 2021/6/3 20:38
 */
public class BlockingQ {

    class Producer implements Runnable {

        private ArrayBlockingQueue<Integer> queue;

        public Producer(ArrayBlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            Random random = new Random();
            while (true) {
                if (queue.size() == 100) {
                    System.out.println("blocking");
                }
                try {
                    queue.put(random.nextInt(100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    class Consumer implements Runnable {

        private ArrayBlockingQueue<Integer> queue;

        public Consumer(ArrayBlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            Random random = new Random();
            while (true) {
                if (queue.size() == 0) {
                    System.out.println("blocking");
                }
                try {
                    queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
