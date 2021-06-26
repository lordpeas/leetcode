package pc;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class Producer1 implements Runnable {


    private Container1 container1;

    public Producer1(Container1 container1) {
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

            container1.put(random.nextInt(100));
        }
    }
}