package base.doublePointer;

import java.util.*;

/**
 * 349. 两个数组的交集
 * <p>
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 解释：[4,9] 也是可通过的
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode349 {
    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2, 2, 1};
        int[] num2 = new int[]{2, 2};
        System.out.println(intersection(num1, num2));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
        Set<Integer> res = new HashSet<>();
        for (int num : nums1) {
            for (int no : nums2) {
                if (no == num) {
                    res.add(no);
                }
            }
        }
        int[] resArr = new int[res.size()];
        int index = 0;
        for (Integer o : res) {
            resArr[index++] = o;
        }

        return resArr;
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        HashSet<Integer> cache = new HashSet<Integer>();
        HashSet<Integer> result = new HashSet<Integer>();
        for (int val : nums1) {
            cache.add(val);
        }

        for (int val : nums2) {
            if (cache.contains(val)){
                result.add(val);
            }
        }

        int[] res = new int[result.size()];
        int index = 0;
        for (int val : result) {
            res[index++] = val;
        }

        return res;
    }
}
