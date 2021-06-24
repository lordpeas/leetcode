package javatest;

/**
 * Description: leetcode
 * Created by : Tianqi Cui
 * Create Date: 2021/6/21 20:27
 */
public class VolatileTest {
    public static volatile int counter = 1;

    public static void main(String[] args){
        counter = 2;
        System.out.println(counter);
    }
}
