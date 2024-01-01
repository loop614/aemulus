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
