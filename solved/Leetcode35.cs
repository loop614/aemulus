public class Solution {
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


public class Aemulus {
    public static void Main(String[] args) {
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

    }
}
