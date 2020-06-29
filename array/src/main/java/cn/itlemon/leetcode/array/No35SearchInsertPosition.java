package cn.itlemon.leetcode.array;

/**
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiangpingping
 * @date 2020/6/28 23:51
 */
public class No35SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1, medium, mediumValue;
        if (target < nums[start]) {
            return 0;
        }
        if (target > nums[end]) {
            return end + 1;
        }
        while (start <= end) {
            if (start == end) {
                return nums[start] < target ? start + 1 : start;
            }
            medium = start + ((end - start) >> 1);
            mediumValue = nums[medium];
            if (mediumValue == target) {
                return medium;
            } else if (mediumValue > target) {
                end = medium;
            } else {
                start = medium + 1;
            }
        }
        return 0;
    }

}
