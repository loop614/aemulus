/*
56. Merge Intervals
Medium
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
and return an array of the non-overlapping intervals that cover all the intervals in the input.
 */
import java.util.Arrays;

public class Leetcode56 {

    public static void main(String[] args) {
        Solution56 sol = new Solution56();
        int[][] res;

        res = sol.merge(new int[][]{{1, 4}, {2, 3}});
        printMatrix(res);
        System.out.println(areMatricesEqual(res, new int[][]{{1, 4}}));

        res = sol.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        printMatrix(res);
        System.out.println(areMatricesEqual(res, new int[][]{{1, 6}, {8, 10}, {15, 18}}));

        res = sol.merge(new int[][]{{1, 4}, {4, 5}});
        printMatrix(res);
        System.out.println(areMatricesEqual(res, new int[][]{{1, 5}}));

        res = sol.merge(new int[][]{{1, 4}, {0, 4}});
        printMatrix(res);
        System.out.println(areMatricesEqual(res, new int[][]{{0, 4}}));
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

class Solution56 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,
                (int[] a, int[] b) -> {
                    return Integer.compare(a[0], b[0]);
                }
        );
        int[][] res = new int[intervals.length][2];
        int pivotInt = 0;
        int pivotRes = 0;
        while (pivotInt < intervals.length) {
            int[] curr = new int[2];
            curr[0] = intervals[pivotInt][0];
            curr[1] = intervals[pivotInt][1];
            while (pivotInt + 1 < intervals.length && intervals[pivotInt + 1][0] <= curr[1]) {
                pivotInt++;
                if (curr[1] < intervals[pivotInt][1]) {
                    curr[1] = intervals[pivotInt][1];
                }
            }
            res[pivotRes++] = curr;
            pivotInt++;
        }

        return Arrays.copyOfRange(res, 0, pivotRes);
    }
}
