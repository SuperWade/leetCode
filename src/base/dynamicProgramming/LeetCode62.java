package base.dynamicProgramming;


/**
 * 62. 不同路径
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：m = 3, n = 7
 * 输出：28
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 * 示例 3：
 * <p>
 * 输入：m = 7, n = 3
 * 输出：28
 * 示例 4：
 * <p>
 * 输入：m = 3, n = 3
 * 输出：6
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode62 {
    public static void main(String[] args) {
//        int m = 3, n = 7;
//        int m = 3, n = 2;
        int m = 3, n = 3;
        System.out.println(uniquePaths2(m, n));
    }

    /**'
     * 动态规划，转移方程
     *  只能向左或者向右，则同x或者y轴只有一种走法，其中转移方程为：dp[x][y] = dp[x-1][y] + dp[x][y -1]
     *  时间复杂度为O(m * n),空间复杂度为O(m * n)
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int y = 0; y < n; y++) {
                if(i == 0 || y == 0){
                    dp[i][y] = 1;
                } else {
                    dp[i][y] = dp[i - 1][y] + dp[i][y - 1];
                }
            }
        }
        return dp[m - 1][n- 1];
    }

    /**
     * 优化上一方法，由于最终只用了一个值，其他的都是中间结果，因此可以使用一个长度为n的数组保存到达每行最后一格所用的步数
     * 时间复杂度O(M * n), 空间复杂度O(m * n)
     *
     * @param m m列
     * @param n n
     * @return int 结果
     */
    public static int uniquePaths2(int m, int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int y = 1; y < n; y++) {
                dp[y] += dp[y - 1];
            }
        }
        return dp[n - 1];
    }
}
