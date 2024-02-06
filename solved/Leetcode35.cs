/*
35. Search Insert Position
Easy
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
You must write an algorithm with O(log n) runtime complexity.
*/

public class Solution {
    /*
     * beats 88% by execution time
     * beats 33% by memory usage
     */
    public int SearchInsert(int[] nums, int target) {
        int i;
        for (i = 0; i < nums.Length; i++)
        {
            if (nums[i] >= target) {
                return i;
            }
        }

        return i;
    }
}

Solution sol = new();
int res;

res = sol.SearchInsert(new int[] {1, 3, 5, 6}, 5);
Console.WriteLine(res);
Console.WriteLine(res == 2);

res = sol.SearchInsert(new int[] {1,3,5,6}, 2);
Console.WriteLine(res);
Console.WriteLine(res == 1);

res = sol.SearchInsert(new int[] {1,3,5,6}, 7);
Console.WriteLine(res);
Console.WriteLine(res == 4);
