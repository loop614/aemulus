/*
18. 4Sum
Medium
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
    0 <= a, b, c, d < n
    a, b, c, and d are distinct.
    nums[a] + nums[b] + nums[c] + nums[d] == target

You may return the answer in any order.
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Leetcode18 {
    public static void main(String[] args) {
        Solution18 sol = new Solution18();
        List<List<Integer>> output;

        output = sol.fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296);
        System.out.println(output);
        System.out.println("[]");
        System.out.println(output.size() == 0);

        output = sol.fourSum(new int[]{0, 5, -8, -7, 4, 8, -4, 3, 9, 7, 8, 10, 3, -6, 3, 7, 10, 0}, -12);
        System.out.println(output);
        System.out.println("[[-8, -7, -6, 9], [-8, -7, -4, 7], [-8, -7, 0, 3], [-8, -4, 0, 0], [-7, -6, -4, 5]]");
        System.out.println(output.size() == 5);

        output = sol.fourSum(new int[]{-2, -1, -1, 1, 1, 2, 2},  0);
        System.out.println(output);
        System.out.println("[[-2, -1, 1, 2], [-1, -1, 1, 1]]");
        System.out.println(output.size() == 2);

        output = sol.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        System.out.println(output);
        System.out.println("[[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]");
        System.out.println(output.size() == 3);

        output = sol.fourSum(new int[]{2, 2, 2, 2, 2},  8);
        System.out.println(output);
        System.out.println("[[2, 2, 2, 2]]");
        System.out.println(output.size() == 1);
    }
}

class Solution18 {
    /**
     * beats 14% by execution time
     * beats 12% by memory usage
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return Arrays.asList();
        }
        if (target < 0) {
            boolean allNumsBiggerThanZero = true;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < 0) {
                    allNumsBiggerThanZero = false;
                    break;
                }
            }
            if (allNumsBiggerThanZero) {
                return Arrays.asList();
            }
        }
        HashSet<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int k = j + 1;
                int x = nums.length - 1;
                int sum = 0;
                while (k < x) {
                    sum = nums[i] + nums[j] + nums[k] + nums[x];
                    if (sum == target) {
                        List<Integer>bear = new ArrayList<>();
                        bear.add(nums[i]);
                        bear.add(nums[j]);
                        bear.add(nums[k]);
                        bear.add(nums[x]);
                        res.add(bear);
                    }
                    if (sum < target) {
                        k++;
                    } else {
                        x--;
                    }
                }
            }
        }

        return new ArrayList<List<Integer>>(res);
    }
}
