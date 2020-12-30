package array;

/**
 * <p>
 * Created by : Tianqi Cui
 * Create Date: 2020/10/12 19:47
 */
public class RemoveDuplicates {

    /**
     * * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * * <p>
     * * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * * <p>
     * *  
     * * <p>
     * * 示例 1:
     * * <p>
     * * 给定数组 nums = [1,1,2],
     * * <p>
     * * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
     * * <p>
     * * 你不需要考虑数组中超出新长度后面的元素。
     * * 示例 2:
     * * <p>
     * * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
     * * <p>
     * * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
     * * <p>
     * * 你不需要考虑数组中超出新长度后面的元素。
     * *  
     * * <p>
     * * 说明:
     * * <p>
     * * 为什么返回数值是整数，但输出的答案是数组呢?
     * * <p>
     * * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
     * * <p>
     * * 你可以想象内部操作如下:
     * * <p>
     * * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
     * * int len = removeDuplicates(nums);
     * * <p>
     * * // 在函数里修改输入数组对于调用者是可见的。
     * * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
     * * for (int i = 0; i < len; i++) {
     * *     print(nums[i]);
     * * }
     * * <p>
     * * 来源：力扣（LeetCode） 删除数组中的重复项
     * * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) return 0;

        int i = 0;
        for (int j = 1; j < nums.length - 1; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }


    /**
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 
     * (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * <p>
     * 说明：你不能倾斜容器，且 n 的值至少为 2。
     * <p>
     * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
     * <p>
     * 示例：
     * <p>
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/container-with-most-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        return 0;
    }
}
