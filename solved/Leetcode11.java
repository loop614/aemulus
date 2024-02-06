/*
11. Container With Most Water
Medium
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.
Notice that you may not slant the container.
*/
public class Leetcode11 {
    public static void main(String[] args) {
        Solution11 sol = new Solution11();
        int res;
        res = sol.maxArea(new int[] {1,8,6,2,5,4,8,3,7});
        System.out.println(res);
        System.out.println(res == 49);

        res = sol.maxArea(new int[] {1,1});
        System.out.println(res);
        System.out.println(res == 1);
    }
}

class Solution11 {
    /*
     * beats 89% by execution time
     * beats 5% by memory usage
     */
    public int maxArea(int[] height) {
        int maxArea = 0;
        int currArea;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            currArea = Math.min(height[i], height[j]) * (j - i);
            if (currArea > maxArea) {
                maxArea = currArea;
            }
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }

        return maxArea;
    }
}
