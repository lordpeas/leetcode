package t;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: leetcode
 * Created by : Tianqi Cui
 * Create Date: 2021年7月7日 22:30
 */
public class Pecs {

    public static void main(String[] args) {

        List<? extends Exception> list = new ArrayList<>();
        Object o = list.get(0);


        List<? super Exception> res = new ArrayList<>();
//        res.add(new Throwable());
        res.add(new RuntimeException());

        List< Number> rs = new ArrayList<>();
        rs.add(1);

    }
}
