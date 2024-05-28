// https://en.wikipedia.org/wiki/Heap%27s_algorithm

public class Heaps
{
    public int[][] PermutationsHeaps(params int[] nums)
    {
        int[] numsC = new int[nums.Length];
        Array.Fill(numsC, 0);

        int fac = 1;
        int i;
        for (i = 0; i < nums.Length; i++)
        {
            fac *= (i + 1);
        }

        int[][] res = new int[fac][];
        for (i = 0; i < fac; i++)
        {
            res[i] = new int[nums.Length];
        }

        Array.Copy(nums, res[0], nums.Length);
        int pivot = 1;

        i = 1;
        int n = nums.Length;

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

                Array.Copy(nums, res[pivot], nums.Length);
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
