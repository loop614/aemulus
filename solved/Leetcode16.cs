public class Solution {
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


public class Aemulus {
    public static void Main(String[] args) {
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
    }
}
