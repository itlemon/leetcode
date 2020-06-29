package cn.itlemon.leetcode.array;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * <p>
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiangpingping
 * @date 2020/6/23 15:40
 */
public class No34FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int start = 0, end = nums.length - 1;
        if (target > nums[end] || target < nums[start]) {
            return new int[]{-1, -1};
        }
        int medium, mediumValue;
        while (start <= end) {
            medium = start + ((end - start) >> 1);
            mediumValue = nums[medium];
            if (target == mediumValue) {
                if (start == end) {
                    return new int[]{start, end};
                } else {
                    int startTemp = medium, endTemp = medium;
                    while (start < medium) {
                        if (target == nums[--medium]) {
                            startTemp = medium;
                        }
                    }
                    while (medium < end) {
                        if (target == nums[++medium]) {
                            endTemp = medium;
                        }
                    }
                    return new int[]{startTemp, endTemp};
                }
            } else if (target > mediumValue) {
                start = medium + 1;
            } else {
                end = medium - 1;
            }
        }
        return new int[]{-1, -1};
    }

}
