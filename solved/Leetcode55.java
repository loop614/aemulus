/*
55. Jump Game
Medium
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
Return true if you can reach the last index, or false otherwise.
 */
public class Leetcode55 {

    public static void main(String... args) {
        Solution55 sol = new Solution55();
        boolean res;

        res = sol.canJump(new int[]{2, 0, 0});
        System.out.println(res == true);

        res = sol.canJump(new int[]{0});
        System.out.println(res == true);

        res = sol.canJump(new int[]{2, 3, 1, 1, 4});
        System.out.println(res == true);

        res = sol.canJump(new int[]{3, 2, 1, 0, 4});
        System.out.println(res == false);
    }
}

class Solution55 {

    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int freemove = 0;
        int i;
        for (i = 0; i < nums.length; i++) {
            freemove--;
            if (freemove < nums[i]) {
                freemove = nums[i];
            }
            if (freemove <= 0) {
                return i == nums.length - 1;
            }
        }

        return i == nums.length;
    }
}
