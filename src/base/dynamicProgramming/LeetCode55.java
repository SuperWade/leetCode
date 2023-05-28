package base.dynamicProgramming;

/**
 * 55. 跳跃游戏
 * <p>
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 104
 * 0 <= nums[i] <= 105
 */
public class LeetCode55 {
    public static void main(String[] args) {
//        int[] nums = {2,3,1,1,4};//true
//        int[] nums = {3, 2, 1, 0, 4};//false
//        int[] nums = {1};// true
//        int[] nums = {0};// true
        int[] nums = {2,5,0,0};
        System.out.println(canJump2(nums));
    }

    public static boolean canJump(int[] nums) {
        boolean flag = false;
        int hasStepNo = nums[0];
        int distance = nums.length;
        int curIndex = 0;
        for (int i = hasStepNo; i > 0; i--) {
            while (hasStepNo > 0) {
                if (nums[curIndex] >= distance) {
                    return true;
                }
                curIndex += hasStepNo;
                distance -= hasStepNo;
                hasStepNo = nums[curIndex];
            }
            curIndex = 0;
            i--;
            curIndex+=i;
        }
        if (hasStepNo + 1 >= distance) {
            return true;
        }
        return flag;
    }

    public static boolean canJump2(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
