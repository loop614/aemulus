/*
1287. Element Appearing More Than 25% In Sorted Array
Easy
Given an integer array sorted in non-decreasing order, there is exactly one integer in the array that occurs more than 25% of the time, return that integer.
*/
public class Leetcode1287 {
    public static void main(String[] args) {
        Solution1287 sol = new Solution1287();
        int output;
        output = sol.findSpecialInteger(new int[]{1,2,2,6,6,6,6,7,10});
        System.out.println(output == 6);
        output = sol.findSpecialInteger(new int[]{1,1});
        System.out.println(output == 1);
        output = sol.findSpecialInteger(new int[]{1});
        System.out.println(output == 1);
        output = sol.findSpecialInteger(new int[]{1,2,3,3});
        System.out.println(output == 3);
        output = sol.findSpecialInteger(new int[]{2,3,3});
        System.out.println(output == 2);
    }
}

class Solution1287 {
    /*
     * beats 100% by execution time
     * beats 80% by memory usage
     */
    public int findSpecialInteger(int[] arr) {
        int prev = arr[0];
        int occ = 0;
        double q = 0.25 * arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (prev == arr[i]) {
                occ++;
                if (occ > q) {
                    return arr[i];
                }
                continue;
            }
            prev = arr[i];
            occ = 1;
        }

        return 0;
    }
}
