/*
46. Permutations
Medium
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
*/
public class Solution
{
    public IList<IList<int>> Permute(int[] nums)
    {
        List<IList<int>> res = [];
        int n = nums.Length;
        int[] numsC = new int[n];
        res.Add(new List<int>(nums));
        int pivot = 1;
        int i = 1;

        while (i < n)
        {
            if (numsC[i] < i)
            {
                if ((i & 1) == 0)
                {
                    (nums[0], nums[i]) = (nums[i], nums[0]);
                }
                else
                {
                    (nums[numsC[i]], nums[i]) = (nums[i], nums[numsC[i]]);
                }

                res.Add(new List<int>(nums));

                pivot++;
                numsC[i] += 1;
                i = 1;
            }
            else
            {
                numsC[i] = 0;
                i += 1;
            }
        }

        return res;
    }
}

IList<IList<int>> res;
Solution sol = new();
res = sol.Permute([1, 2, 3]);

foreach (IList<int> one in res)
{
    Console.WriteLine(string.Join("", one));
}
