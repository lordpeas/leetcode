package pc;

import java.util.LinkedList;
import java.util.Random;


public class Consumer1 implements Runnable {

    private Container1 container1;

    public Consumer1(Container1 container1) {
        this.container1 = container1;
    }

    @Override
    public void run() {
        Random random = new Random();

        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Integer take = container1.take();
        }
    }


    public static void main(String[] args) {
        Container1 container1 = new Container1(new LinkedList<>(),10);
        Thread producer1 = new Thread(new Producer1(container1));
        Thread producer2 = new Thread(new Producer1(container1));
        Thread producer3 = new Thread(new Producer1(container1));
        Thread producer4 = new Thread(new Producer1(container1));
        Thread producer5 = new Thread(new Producer1(container1));

        producer1.start();
        producer2.start();
        producer3.start();
        producer4.start();
        producer5.start();

        Thread consumer1 = new Thread(new Consumer1(container1));
        Thread consumer2 = new Thread(new Consumer1(container1));
        Thread consumer3 = new Thread(new Consumer1(container1));
        Thread consumer4 = new Thread(new Consumer1(container1));
        Thread consumer5 = new Thread(new Consumer1(container1));
        consumer1.start();
        consumer2.start();
        consumer3.start();
        consumer4.start();
        consumer5.start();
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
