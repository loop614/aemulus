/*
59. Spiral Matrix II
Medium
Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 */
import java.util.Arrays;

public class Leetcode59 {

    public static void main(String[] args) {
        Solution59 sol = new Solution59();
        int[][] res;

        res = sol.generateMatrix(4);
        printMatrix(res);
        System.out.println(areMatricesEqual(res, new int[][]{{1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10, 9, 8, 7}}));

        res = sol.generateMatrix(3);
        printMatrix(res);
        System.out.println(areMatricesEqual(res, new int[][]{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}}));

        res = sol.generateMatrix(2);
        printMatrix(res);
        System.out.println(areMatricesEqual(res, new int[][]{{1, 2}, {4, 3}}));

        res = sol.generateMatrix(1);
        printMatrix(res);
        System.out.println(areMatricesEqual(res, new int[][]{{1}}));
    }

    private static void printMatrix(int[][] a) {
        for (int[] a1 : a) {
            System.out.print(Arrays.toString(a1));
            System.out.print(" ");
        }
        System.out.print("\n");
    }

    private static boolean areMatricesEqual(int[][] a, int[][] b) {
        if (a.length != b.length || a[0].length != b[0].length) {
            return false;
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}

class Solution59 {

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int pivot = 1;
        int ts = 0;
        int te = n - 1;
        int rs = 0;
        int re = n - 1;
        int bs = n - 1;
        int be = 0;
        int ls = n - 1;
        int le = 0;

        while (true) {
            for (int i = ts; i <= te; i++) {
                res[rs][i] = pivot++;
            }
            rs++;
            le++;
            if (pivot > n * n) {
                break;
            }

            for (int i = rs; i <= re; i++) {
                res[i][bs] = pivot++;
            }
            bs--;
            te--;
            if (pivot > n * n) {
                break;
            }

            for (int i = bs; i >= be; i--) {
                res[ls][i] = pivot++;
            }
            ls--;
            re--;
            if (pivot > n * n) {
                break;
            }

            for (int i = ls; i >= le; i--) {
                res[i][ts] = pivot++;
            }
            ts++;
            be++;

            if (pivot > n * n) {
                break;
            }
        }

        return res;
    }
}
