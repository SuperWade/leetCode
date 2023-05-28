package base.dynamicProgramming;

import java.util.*;

/**
 * 119. 杨辉三角 II
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * <p>
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: rowIndex = 3
 * 输出: [1,3,3,1]
 * 示例 2:
 * <p>
 * 输入: rowIndex = 0
 * 输出: [1]
 * 示例 3:
 * <p>
 * 输入: rowIndex = 1
 * 输出: [1,1]
 *  
 * <p>
 * 提示:
 * <p>
 * 0 <= rowIndex <= 33
 *  
 * <p>
 * 进阶：
 * <p>
 * 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/pascals-triangle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode119 {
    private static int[][] arr = new int[33][33];

    public static void main(String[] args) {
        System.out.println(getRow(5));
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        // 记录每行中的数据
        arr[0][0] = 1;
        arr[1][0] = 1;
        arr[1][1] = 1;
        for (int i = 2; i <= rowIndex; i++) {
            arr[i][0] = 1;
            for (int y = 1; y <= rowIndex; y++) {
                arr[i][y] = arr[i - 1][y - 1] + arr[i - 1][y];
            }
        }
        for (int i = 0; i <= rowIndex; i++) {
            res.add(arr[rowIndex][i]);
        }
        return res;
    }

    /**
     * 最优解，使用数学公式相邻组合关系当前行=上一行*（n - m + 1） / m
     *复杂度分析
     * 时间复杂度：O(rowIndex)。
     * 空间复杂度： O(1)
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow2(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for(int i=1;i<=rowIndex;i++){
            list.add((int) ((long) list.get(i - 1) * (rowIndex - i + 1) / i));
        }
        return list;
    }
}
