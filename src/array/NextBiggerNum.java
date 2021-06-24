package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Description: 输入一个正整数，数字中每一位的数重新排列后等到新的正整数， 给出重排后比原数字大的且最小的新数字。
 * Created by : Tianqi Cui
 * Create Date: 2021年5月27日 00:15
 */


public class NextBiggerNum {


    public int getNextBigger(int num) {
        List<Integer> list = new ArrayList<>();
        while (num > 0) {
            int i = num % 10;
            list.add(i);
            num = num / 10;
        }
        Collections.reverse(list);
        Integer[] array = list.toArray(new Integer[0]);

        int n = array.length;
        for (int i = n - 1; i > 0; i--) {
            if (array[i] > array[i - 1]) {
                Arrays.sort(array, i, n);
                for (int j = i; j < n; j++) {
                    if (array[j] > array[i - 1]) {
                        int temp = array[i - 1];
                        array[i - 1] = array[j];
                        array[j] = temp;
                        Arrays.sort(array, j, n);
                        System.out.println(Arrays.toString(array));
                        int res = 0;
                        for (int k = 0; k < n; k++) {
                            res = res * 10 + array[k];
                        }

                        return res;
                    }
                }
            }
        }
        return num;
    }


    public static void main(String[] args) {
        int bigger = new NextBiggerNum().getNextBigger(121314);
        System.out.println(bigger);
    }

}
