/*
57. Insert Interval
Medium
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
Return intervals after the insertion.
Note that you don't need to modify intervals in-place. You can make a new array and return it.
 */
import java.util.Arrays;

public class Leetcode57 {

    public static void main(String... args) {
        Solution57 sol = new Solution57();
        int[][] res;

        res = sol.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5});
        printMatrix(res);
        System.out.println(areMatricesEqual(res, new int[][]{{1, 5}, {6, 9}}));

        res = sol.insert(new int[][]{{1, 5}, {6, 8}}, new int[]{0, 9});
        printMatrix(res);
        System.out.println(areMatricesEqual(res, new int[][]{{0, 9}}));

        res = sol.insert(new int[][]{{1, 5}}, new int[]{2, 3});
        printMatrix(res);
        System.out.println(areMatricesEqual(res, new int[][]{{1, 5}}));

        res = sol.insert(new int[][]{}, new int[]{5, 7});
        printMatrix(res);
        System.out.println(areMatricesEqual(res, new int[][]{{5, 7}}));

        res = sol.insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8});
        printMatrix(res);
        System.out.println(areMatricesEqual(res, new int[][]{{1, 2}, {3, 10}, {12, 16}}));
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

class Solution57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] res = new int[intervals.length + 1][2];
        int p = findPositionNewElement(intervals, newInterval);
        System.arraycopy(intervals, 0, res, 0, p);
        res[p] = newInterval;
        if (intervals.length - p > 0) {
            System.arraycopy(intervals, p, res, p + 1, intervals.length - p);
        }

        return merge(res, p - 1);
    }

    private static int findPositionNewElement(int[][] intervals, int[] newInterval) {
        int l = 0;
        int r = intervals.length;
        int p = 0;
        while (l < r) {
            p = l + (r - l) / 2;
            if (intervals[p][0] < newInterval[0]) {
                l = p + 1;
            } else if (intervals[p][0] > newInterval[0]) {
                r = p - 1;
            } else {
                return p;
            }
        }

        for (int i = Math.max(l - 1, 0); i <= Math.min(r + 1, intervals.length - 1); i++) {
            if (intervals[i][0] > newInterval[0]) {
                return i;
            }
        }

        return Math.max(l, r);
    }

    private static int[][] merge(int[][] intervals, int startPos) {
        startPos = Math.max(startPos, 0);
        int[][] res = new int[intervals.length][2];
        System.arraycopy(intervals, 0, res, 0, startPos);
        int pivotInt = startPos;
        int pivotRes = startPos;
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
