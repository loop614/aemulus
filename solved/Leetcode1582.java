import java.util.Arrays;

// public class Main {
//     public static void main(String[] args) {
//         Solution sol = new Solution();
//         int output;
//         output = sol.numSpecial(new int[][]{{1,0,0},{0,0,1},{1,0,0}});
//         System.out.println(output);
//         System.out.println(output == 1);
//         output = sol.numSpecial(new int[][]{{1,0,0},{0,1,0},{0,0,1}});
//         System.out.println(output);
//         System.out.println(output == 3);
//         output = sol.numSpecial(new int[][]{{1,0},{0,1},{1,0}});
//         System.out.println(output);
//         System.out.println(output == 1);
//         output = sol.numSpecial(new int[][]{{0,0,1,0},{0,0,0,0},{0,0,0,0},{0,1,0,0}});
//         System.out.println(output);
//         System.out.println(output == 2);
//         output = sol.numSpecial(new int[][]{{0,0,0,1},{1,0,0,0},{0,1,1,0},{0,0,0,0}});
//         System.out.println(output);
//         System.out.println(output == 2);
//         output = sol.numSpecial(new int[][]{{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,1},{0,0,0,0,1,0,0,0},{1,0,0,0,1,0,0,0},{0,0,1,1,0,0,0,0}});
//         System.out.println(output);
//         System.out.println(output == 1);
//     }
// }


class Solution1582 {
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
