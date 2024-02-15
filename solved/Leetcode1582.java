/*
1582. Special Positions in a Binary Matrix
Easy
Given an m x n binary matrix mat, return the number of special positions in mat.
A position (i, j) is called special if mat[i][j] == 1 and all other elements in row i and column j are 0 (rows and columns are 0-indexed).
*/
import java.util.Arrays;

public class Leetcode1582 {
    public static void main(String[] args) {
        Solution1582 sol = new Solution1582();
        int output;
        output = sol.numSpecial(new int[][]{{1,0,0},{0,0,1},{1,0,0}});
        System.out.println(output);
        System.out.println(output == 1);
        output = sol.numSpecial(new int[][]{{1,0,0},{0,1,0},{0,0,1}});
        System.out.println(output);
        System.out.println(output == 3);
        output = sol.numSpecial(new int[][]{{1,0},{0,1},{1,0}});
        System.out.println(output);
        System.out.println(output == 1);
        output = sol.numSpecial(new int[][]{{0,0,1,0},{0,0,0,0},{0,0,0,0},{0,1,0,0}});
        System.out.println(output);
        System.out.println(output == 2);
        output = sol.numSpecial(new int[][]{{0,0,0,1},{1,0,0,0},{0,1,1,0},{0,0,0,0}});
        System.out.println(output);
        System.out.println(output == 2);
        output = sol.numSpecial(new int[][]{{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,1},{0,0,0,0,1,0,0,0},{1,0,0,0,1,0,0,0},{0,0,1,1,0,0,0,0}});
        System.out.println(output);
        System.out.println(output == 1);
    }
}


class Solution1582 {
    /*
     * beats 76% by execution time
     * beats 37% by memory usage
     */
    public int numSpecial(int[][] nums) {
        int specialCount = 0;
        boolean isSpecial = false;
        boolean[] colsWithOne = new boolean[nums[0].length];
        Arrays.fill(colsWithOne, false);

        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums[i].length; j++) {
                isSpecial = false;
                if (nums[i][j] == 1 && !colsWithOne[j]) {
                    isSpecial = true;
                    colsWithOne[j] = true;
                    for(int a = 0; a < nums[i].length; a++) {
                        if (j != a && nums[i][a] == 1) {
                            isSpecial = false;
                            break;
                        }
                    }
                    if (isSpecial) {
                        for(int b = 0; b < nums.length; b++) {
                            if (i != b && nums[b][j] == 1) {
                                isSpecial = false;
                                break;
                            }
                        }
                    }
                    if (isSpecial) {
                        specialCount++;
                    }
                    break;
                }
            }
        }

        return specialCount;
    }
}
