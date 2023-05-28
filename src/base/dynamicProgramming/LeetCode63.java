package base.dynamicProgramming;

/**
 * 63.不同路径II
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * 解释：3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * 示例 2：
 * <p>
 * <p>
 * 输入：obstacleGrid = [[0,1],[0,0]]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == obstacleGrid.length
 * n == obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] 为 0 或 1
 * <p>
 * 切换为
 * 英文
 */
public class LeetCode63 {
    public static void main(String[] args) {
//        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
//        int[][] obstacleGrid = {{0, 1}, {0, 0}};
//        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] obstacleGrid = {{0,0},{1,1},{0,0}};
        System.out.println(uniquePathsWithObstacles2(obstacleGrid));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int numX = obstacleGrid.length;
        int numY = obstacleGrid[0].length;
        int[][] dp = new int[numX][numY];
        for (int i = 0; i < numX; i++) {
            for (int y = 0; y < numY; y++) {
                if (obstacleGrid[i][y] == 1) {
                    dp[i][y] = 0;
                } else if (i == 0 || y == 0) {
                    if(i == 0 && y - 1 >= 0) {
                        dp[i][y] = dp[i][y - 1];
                    } else if(y == 0 && i - 1 >= 0){
                        dp[i][y] = dp[i - 1][y];
                    } else {
                        dp[i][y] = 1;
                    }
                } else {
                    dp[i][y] = dp[i - 1][y] + dp[i][y - 1];
                }
            }
        }
        return dp[numX - 1][numY - 1];
    }

    public static int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int numX = obstacleGrid.length;
        int numY = obstacleGrid[0].length;
        int[] dp = new int[numY];
        dp[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 0; i < numX; i++) {
            for (int j = 0; j < numY; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else if (j > 0) {
                    if (i == 0) {
                        dp[j] = dp[j - 1];
                    } else {
                        dp[j] += dp[j - 1];
                    }
                }
            }
        }
        return dp[numY - 1];
    }
}
