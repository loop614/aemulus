/*
15. 3Sum
Medium
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Leetcode15 {
    public static void main(String[] args) {
        Solution15 sol = new Solution15();
        List<List<Integer>> output;

        output = sol.threeSum(new int[]{-1,0,1,2,-1,-4});
        System.out.println(output);
        System.out.println("[[-1,-1,2],[-1,0,1]]");
        System.out.println(output.size() == 2);

        output = sol.threeSum(new int[]{0,1,1});
        System.out.println(output);
        System.out.println("[]");
        System.out.println(output.size() == 0);

        output = sol.threeSum(new int[]{0,0,0});
        System.out.println(output);
        System.out.println("[[0,0,0]]");
        System.out.println(output.size() == 1);
    }
}

class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            int sum = 0;
                while (j < k) {
                    sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0) {
                        List<Integer>bear = new ArrayList<>();
                        bear.add(nums[i]);
                        bear.add(nums[j]);
                        bear.add(nums[k]);
                        res.add(bear);
                    }
                    if (sum < 0) {
                        j++;
                    } else {
                        k--;
                    }
                }
        }

        return new ArrayList<List<Integer>>(res);
    }
}
