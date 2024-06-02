/*
54. Spiral Matrix
Medium
Given an m x n matrix, return all elements of the matrix in spiral order.
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode54 {
    public static void main(String[] args) {
        Solution54 sol = new Solution54();
        List<Integer> res, expected;

        res = sol.spiralOrder(new int[][] {{7},{9},{6}});
        expected = new ArrayList(Arrays.asList(7,9,6));
        System.out.println(res.toString());
        System.out.println(expected.equals(res));

        res = sol.spiralOrder(new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}});
        expected = new ArrayList(Arrays.asList(1,2,3,4,8,12,11,10,9,5,6,7));
        System.out.println(res.toString());
        System.out.println(expected.equals(res));

        res = sol.spiralOrder(new int[][] {{1,2,3}});
        expected = new ArrayList(Arrays.asList(1,2,3));
        System.out.println(res.toString());
        System.out.println(expected.equals(res));

        res = sol.spiralOrder(new int[][] {{1,2,3},{4,5,6},{7, 8,9}});
        expected = new ArrayList(Arrays.asList(1,2,3,6,9,8,7,4,5));
        System.out.println(res.toString());
        System.out.println(expected.equals(res));
    }
}

class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>(matrix.length + matrix[0].length);
        int x = 0, y = 0;
        int numcount = matrix.length * matrix[0].length;
        int xstart = 0, xend = matrix[0].length, ystart = 0, yend = matrix.length;
        while (true) {
            for (x = xstart; x < xend; x++) {
                res.add(matrix[y][x]);
                numcount--;
            }
            if (numcount <= 0) {break;}
            x--;
            ystart++;
            for (y = ystart; y < yend; y++) {
                res.add(matrix[y][x]);
                numcount--;
            }
            if (numcount <= 0) {break;}
            x--;
            y--;
            xend--;
            for (; x >= xstart; x--) {
                res.add(matrix[y][x]);
                numcount--;
            }
            if (numcount <= 0) {break;}
            x++;
            y--;
            yend--;
            for (; y >= ystart; y--) {
                res.add(matrix[y][x]);
                numcount--;
            }
            if (numcount <= 0) {break;}
            y++;
            xstart++;
        }

        return res;
    }
}
