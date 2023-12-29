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
