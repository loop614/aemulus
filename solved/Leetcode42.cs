/*
42. Trapping Rain Water
Hard
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
*/
public class Solution {
    public int Trap(int[] height) {
        int total = 0;
        int maxLeft = height[0];
        int[] maxRightPerIndex = new int[height.Length];
        int maxRight = 0;
        int curr;

        for (int i = height.Length-1; i >= 0; i--) {
            if (maxRight < height[i]) {
                maxRight = height[i];
            }
            maxRightPerIndex[i] = maxRight;
        }

        for (int i = 1; i < height.Length; i++) {
            if (height[i-1] > maxLeft) {
                maxLeft = height[i-1];
            }

            curr = Math.Min(maxLeft, maxRightPerIndex[i]) - height[i];
            if (curr > 0) {
                total +=  curr;
            }
        }

        return total;
    }
}

int res;
Solution sol = new();
res = sol.Trap([0,1,0,2,1,0,1,3,2,1,2,1]);
Console.WriteLine(res);
Console.WriteLine(res == 6);

res = sol.Trap([4,2,0,3,2,5]);
Console.WriteLine(res);
Console.WriteLine(res == 9);

res = sol.Trap([0,2,0]);
Console.WriteLine(res);
Console.WriteLine(res == 0);
