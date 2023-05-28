package base.doublePointer;

/**
 * 75. 颜色分类
 * <p>
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 * <p>
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 *  
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode75 {
    public static void main(String[] args) {

    }

    public static void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        // 记录起始位置
        int start = 0;
        int end = nums.length;
        // 首先判断颜色
        for (int i = 0; i < end;) {
            // 如果当前颜色为蓝色，不做任何改变，继续下一位；如果为蓝色则将其放与最后一位交换
            if (nums[start] == 1) {
                i++;
            } else if (nums[start] == 2) {
                swap(nums, start, --end);
            } else {
                // 如果是红色，则判断当前位置是否在当前数组中的最后一个红色后面，是则不变，不是则与最后一个红色的下一个交换
                if (start == i) {
                    start++;
                } else {
                    swap(nums, start+1, i);
                }
            }
        }
    }

    private static void swap(int[] nums, int start, int end) {
        int curNum = nums[start];
        nums[start] = nums[end];
        nums[end] = curNum;
    }
}
