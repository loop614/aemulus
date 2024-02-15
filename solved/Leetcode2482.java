import java.util.Arrays;

/*
2482. Difference Between Ones and Zeros in Row and Column
Medium

You are given a 0-indexed m x n binary matrix grid.
A 0-indexed m x n difference matrix diff is created with the following procedure:
    Let the number of ones in the ith row be onesRowi.
    Let the number of ones in the jth column be onesColj.
    Let the number of zeros in the ith row be zerosRowi.
    Let the number of zeros in the jth column be zerosColj.
    diff[i][j] = onesRowi + onesColj - zerosRowi - zerosColj
Return the difference matrix diff.
*/
public class Leetcode2482 {
    public static void main(String[] args) {
        Solution2482 sol = new Solution2482();
        int[][] output;

        output = sol.onesMinusZeros(new int[][]{{0,1,1},{1,0,1},{0,0,1}});
        System.out.println(sol.printMatrix(output));
        System.out.println(sol.areMatricesEqual(output, new int[][]{{0,0,4},{0,0,4},{-2,-2,2}}));

        output = sol.onesMinusZeros(new int[][]{{1,1,1},{1,1,1}});
        System.out.println(sol.printMatrix(output));
        System.out.println(sol.areMatricesEqual(output, new int[][]{{5,5,5},{5,5,5}}));
    }
}

class Solution2482 {
    /*
     * beats 14% by execution time
     * beats 23% by memory usage
     */
    public int[][] onesMinusZeros(int[][] nums) {
        int[][] res = new int[nums.length][nums[0].length];
        int[] zeroRows = new int[nums.length];
        int[] oneRows = new int[nums.length];
        int[] zeroCols = new int[nums[0].length];
        int[] oneCols = new int[nums[0].length];

        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums[i].length; j++) {
                if (nums[i][j] == 0) {
                    zeroRows[i]++;
                    zeroCols[j]++;
                }
                if (nums[i][j] == 1) {
                    oneRows[i]++;
                    oneCols[j]++;
                }
            }
        }

        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums[i].length; j++) {
                res[i][j] = oneRows[i] + oneCols[j] - zeroRows[i] - zeroCols[j] ;
            }
        }

        return res;
    }

    public boolean areMatricesEqual(int[][] a, int[][] b) {
        if(a.length != b.length || a[0].length != b[0].length){
            return false;
        }

        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[i].length; j++){
                if(a[i][j] != b[i][j]){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean printMatrix(int[][] a) {
        for(int i = 0; i < a.length; i++){
            System.out.println(Arrays.toString(a[i]));
        }

        return true;
    }
}
