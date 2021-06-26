package pc;

import java.util.LinkedList;
import java.util.Queue;

public class Container1 {

    private Integer capacity;

    private LinkedList<Integer> list = new LinkedList<>();


    public Container1(LinkedList<Integer> list, Integer capacity) {
        this.list = list;
        this.capacity = capacity;
    }

    public void put(Integer item){

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                while (list.size() == capacity) {
                    System.out.println(Thread.currentThread().getName() + " put  blocking");
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("producer--" + Thread.currentThread().getName() + "--put:" + item);
                list.add(item);
                notifyAll();
            }
    }


    public Integer take(){
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this){
            while (list.size()==0){
                System.out.println(Thread.currentThread().getName() + " take  blocking");
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Integer value = list.poll();
            notifyAll();
            System.out.println("producer--" + Thread.currentThread().getName() + "--get:" + value);
            return value;
        }
    }


}
