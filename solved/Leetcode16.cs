/*
16. 3Sum Closest
Medium
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
Return the sum of the three integers.
You may assume that each input would have exactly one solution.
*/
public class Solution {
    /**
     * beats 99% by execution time
     * beats 71% by memory usage
     */
    public int ThreeSumClosest(int[] nums, int target) {
        int minDistance = 100000;
        int curDistance;
        int curSumOfThree;
        int minSumOfThree = 0;
        int j, k;
        Array.Sort(nums);
        for (int i = 0; i < nums.Length - 2; i++) {
            j = i + 1;
            k = nums.Length - 1;
            while (j < k) {
                curSumOfThree = nums[i] + nums[j] + nums[k];
                curDistance = Math.Abs(target - curSumOfThree);
                if (curDistance == 0) {
                    return target;
                }

                if (curDistance < minDistance) {
                    minDistance = curDistance;
                    minSumOfThree = curSumOfThree;
                }

                if (curSumOfThree > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return minSumOfThree;
    }

    public int ThreeSumClosest2(int[] nums, int target) {
        int minDistance = 100000;
        int curDistance;
        int curSumOfThree;
        int minSumOfThree = 0;
        for (int i = 0; i < nums.Length-2; i++) {
            for (int j = i+1; j < nums.Length-1; j++) {
                for (int k = j+1; k < nums.Length; k++) {
                    curSumOfThree = nums[i] + nums[j] + nums[k];
                    curDistance = Math.Abs(target - curSumOfThree);
                    if (curDistance == 0) {
                        return target;
                    }
                    if (curDistance < minDistance) {
                        minDistance = curDistance;
                        minSumOfThree = curSumOfThree;
                    }
                }
            }
        }

        return minSumOfThree;
    }
}

Solution sol = new();
int res;

res = sol.ThreeSumClosest(new []{-1,2,1,-4}, 1);
Console.WriteLine(res);
Console.WriteLine(res == 2);

res = sol.ThreeSumClosest(new []{0,0,0}, 1);
Console.WriteLine(res);
Console.WriteLine(res == 0);

res = sol.ThreeSumClosest(new []{4,0,5,-5,3,3,0,-4,-5}, -2);
Console.WriteLine(res);
Console.WriteLine(res == -2);
