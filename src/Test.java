import java.util.WeakHashMap;

/**
 * Description: leetcode
 * Created by : Tianqi Cui
 * Create Date: 2021年3月14日 17:02
 */
public abstract class Test {


    abstract void run();

     void test(){
    }



    public static void main(String[] args) {
        Test test = new Test() {
            @Override
            void run() {

            }
        };
    }
}

interface  test1{
    public abstract void run();
}
