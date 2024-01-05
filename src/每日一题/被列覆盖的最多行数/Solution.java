package 每日一题.被列覆盖的最多行数;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Classname Solution
 * @Description https://leetcode.cn/problems/maximum-rows-covered-by-columns/description/
 * @Date 2024/1/4 22:35
 * @Created by ahh
 */
public class Solution {

    public static void main(String[] args) {
        List<List<Integer>> combinations = combinations(9, 9);
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
        System.out.println(combinations.size());
    }

    /**
     * 在0 - (n - 1) 的范围内中选取x个数字，输出所有组合
     *
     * @param n
     * @param k
     */
    public static List<List<Integer>> combinations(int n, int k) {
        if (k == 1) {
            List<List<Integer>> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                list.add(Stream.of(i).collect(Collectors.toList()));
            }
            return list;
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            List<List<Integer>> combinations = combinations(n, k - 1);
            for (List<Integer> combination : combinations) {
                if (!combination.contains(i)) {
                    combination.add(i);
                    Collections.sort(combination);
                    if (!res.contains(combination)) {
                        res.add(combination);
                    }

                }
            }

        }
        return res;
    }

    private int maxRowsCovered = 0;

    public int maximumRows(int[][] matrix, int numSelect) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> rows = new ArrayList<>();

        // 将每行的1所在列转换为整数表示
        for (int[] row : matrix) {
            int rowBitmask = 0;
            for (int col = 0; col < n; col++) {
                if (row[col] == 1) {
                    rowBitmask |= 1 << col;
                }
            }
            rows.add(rowBitmask);
        }

        backtrack(0, numSelect, 0, rows, n);
        return maxRowsCovered;
    }

    private void backtrack(int start, int numSelect, int selectedCols, List<Integer> rows, int n) {
        // 检查当前列组合能覆盖多少行
        int count = countCoveredRows(selectedCols, rows);
        maxRowsCovered = Math.max(maxRowsCovered, count);

        // 如果已经达到需要选择的列数或已经覆盖所有行，结束回溯
        if (numSelect == 0 || maxRowsCovered == rows.size()) return;

        for (int i = start; i < n; i++) {
            // 选择列i
            selectedCols |= 1 << i;
            backtrack(i + 1, numSelect - 1, selectedCols, rows, n);
            // 回溯，撤销选择列i
            selectedCols &= ~(1 << i);
        }
    }

    private int countCoveredRows(int selectedCols, List<Integer> rows) {
        int count = 0;
        for (int row : rows) {
            if ((row & selectedCols) == row) {
                count++;
            }
        }
        return count;
    }

}

