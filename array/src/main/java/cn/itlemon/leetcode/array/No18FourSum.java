package cn.itlemon.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？
 * 找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiangpingping
 * @date 2020/6/19 13:45
 */
public class No18FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        int first, second, third, fourth;
        for (first = 0; first < nums.length - 3; first++) {
            // 忽略与前值相同的值
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // 剪枝，判断最小和与target
            int minSum = nums[first] + nums[first + 1] + nums[first + 2] + nums[first + 3];
            if (minSum > target) {
                break;
            }
            // 剪枝，判断最大和与target
            int maxSum = nums[first] + nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1];
            if (maxSum < target) {
                continue;
            }
            for (second = first + 1; second < nums.length - 2; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                third = second + 1;
                fourth = nums.length - 1;
                int minSum1 = nums[first] + nums[second] + nums[third] + nums[third + 1];
                if (minSum1 > target) {
                    break;
                }
                int maxSum1 = nums[first] = nums[second] + nums[fourth - 1] + nums[fourth];
                if (maxSum < target) {
                    continue;
                }
                while (third < fourth) {
                    int sum = nums[first] + nums[second] + nums[third] + nums[fourth];
                    if (sum < target) {
                        // 既-1了，也避免了指针向前的重复元素
                        while (third < fourth && nums[fourth] == nums[--fourth]) {
                        }
                    } else if (sum > target) {
                        // 既+1了，也避免了指针向后的重复元素
                        while (third < target && nums[third] == nums[++third]) {
                        }
                    } else {
                        result.add(new ArrayList<>(Arrays.asList(nums[first], nums[second], nums[third], nums[fourth])));
                        while (third < fourth && nums[fourth] == nums[--fourth]) {
                        }
                        while (third < target && nums[third] == nums[++third]) {
                        }
                    }
                }
            }
        }
        return result;
    }

}
