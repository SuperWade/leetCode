package base.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 120. 三角形最小路径和
 * <p>
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * <p>
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 示例 2：
 * <p>
 * 输入：triangle = [[-10]]
 * 输出：-10
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -104 <= triangle[i][j] <= 104
 *  
 * <p>
 * 进阶：
 * <p>
 * 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode120 {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(minimumTotal0(triangle));
    }


    /**
     * 最原始的解法
     *
     * @param triangle
     * @return
     */
    public static int minimumTotal0(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] f = new int[n][n];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; ++j) {
                f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
            }
            f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int minTotal = f[n - 1][0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[n - 1][i]);
        }
        return minTotal;
    }

    /**
     * 错误四楼
     *
     * @param triangle
     * @return
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        // 下一步的最优解在上一步的最优解基础上
        int res = 0;
        if (triangle == null) {
            return res;
        }
        // 当前循环最小值，以及对应坐标
        int coordinate = 0;

        for (int i = 0; i < triangle.size(); i++) {
            int curMin = Integer.MAX_VALUE;
            List<Integer> cur = triangle.get(i);
            for (int y = 0; y < cur.size(); y++) {
                if (Math.abs(y - coordinate) <= 1 && cur.get(y) <= curMin) {
                    curMin = cur.get(y);
                    coordinate = y;

                }
            }
            res += curMin;
        }
        return res;
    }

    public static int minimumTotal2(List<List<Integer>> triangle) {
        // 下一步的最优解在上一步的最优解基础上
        if (triangle == null) {
            return  0;
        }

        int size = triangle.size();
        int[] minPath = new int[size];
        minPath[0] = triangle.get(0).get(0);
        for (int i = 1; i < size; i++) {
            List<Integer> cur = triangle.get(i);
            minPath[i] = minPath[i - 1] + cur.get(i);
            for (int y = i - 1; y > 0; --y) {
                minPath[y] = Math.min(minPath[y - 1], minPath[y]) + cur.get(y);
            }
            minPath[0]+= cur.get(0);
        }
        int res = minPath[0];
        for (int i = 1; i < size; ++i) {
            res = Math.min(res, minPath[i]);
        }
        return res;
    }
}
