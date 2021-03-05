package nextgreaterelement;

import java.util.LinkedList;

/**
 * Description: leetcode
 * Created by : Tianqi Cui
 * Create Date: 2021/3/5 16:31
 */

//给你一个数组T，这个数组存放的是近几天的天气气温，你返回一个等长的数组，计算：对于每一天，你还要至少等多少天才能等到一个更暖和的气温；如果等不到那一天，填 0。
//
//        函数签名如下：
//
//        vector<int> dailyTemperatures(vector<int>& T);
//        比如说给你输入T = [73,74,75,71,69,76]，你返回[1,1,3,2,1,0]。
//
//        解释：第一天 73 华氏度，第二天 74 华氏度，比 73 大，所以对于第一天，只要等一天就能等到一个更暖和的气温，后面的同理。
//
//        这个问题本质上也是找 Next Greater Number，只不过现在不是问你 Next Greater Number 是多少，而是问你当前距离 Next Greater Number 的距离而已。
public class DailyTemperatures {

    int[] dailyTemperatures(int [] nums){
        int[] res = new int[nums.length];
        LinkedList<Integer> s = new LinkedList<>();

        for (int i = nums.length-1 ;i >=0 ; i--) {
            while (!s.isEmpty()&& nums[s.getFirst()]<=nums[i]){
                s.pop();
            }
            res[i] = s.isEmpty()?-1:s.getFirst()-i;
            //索引入栈 而不是元素
            s.push(i);
        }
        return res;
    }
}
