/*
455. Assign Cookies
Easy
Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.
Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with; and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.
*/
import java.util.Arrays;

public class Leetcode455 {
    public static void main(String[] args) {
        Solution455 sol = new Solution455();
        int res;

        res = sol.findContentChildren(new int[] {10,9,8,7}, new int[] {5,6,7,8});
        System.out.println(res);
        System.out.println(res == 2);

        res = sol.findContentChildren(new int[] {1,2,3}, new int[] {1,1});
        System.out.println(res);
        System.out.println(res == 1);

        res = sol.findContentChildren(new int[] {1,2}, new int[] {1,2, 3});
        System.out.println(res);
        System.out.println(res == 2);
    }
}


class Solution455 {
    /*
     * beats 99% by execution time
     * beats 66% by memory usage
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int pivotG = 0, pivotS = 0;

        while (pivotG < g.length && pivotS < s.length) {
            if (s[pivotS] >= g[pivotG]) {
                pivotG++;
                pivotS++;
            } else {
                pivotS++;
            }
        }

        return pivotG;
    }
}
