package nextgreaterelement;

import java.util.LinkedList;
import java.util.List;

/**
 * Description: leetcode
 * Created by : Tianqi Cui
 * Create Date: 2021/3/4 19:47
 */
public class NextGreaterElement {

    //    给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
//
//    请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
//
//    nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/next-greater-element-i

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] res = new int[nums1.length];
        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.getFirst() <= nums2[i]) {
                stack.pop();
            }

            for (int j = 0; j < nums1.length ; j++) {
                if(nums1[j] == nums2[i]){
                    res[j] = stack.isEmpty()? -1:stack.getFirst();
                    break;
                }
            }


            stack.push(nums2[i]);
        }
        return res;
    }
}
