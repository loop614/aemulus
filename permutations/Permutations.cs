// TODO: add Heap's algorithm

public class NumberInfo
{
    public int value;

    public bool directionLeft;

    public bool isMobile;

    public NumberInfo(int val)
    {
        this.value = val;
        this.directionLeft = true;
        this.isMobile = false;
    }

    public static bool operator <(NumberInfo left, NumberInfo right)
    {
        return (left.value < right.value);
    }

    public static bool operator >(NumberInfo left, NumberInfo right)
    {
        return (left.value > right.value);
    }
}

public class Solution
{
    public int[][] PermutationsJohnsonTrotter(params int[] nums)
    {
        NumberInfo[] nis = new NumberInfo[nums.Length];
        int gretestMobileIndex;
        int fac = 1;

        for (int i = 0; i < nums.Length; i++)
        {
            fac *= (i + 1);
            nis[i] = new NumberInfo(nums[i]);
        }

        int[][] res = new int[fac][];
        for (int i = 0; i < fac; i++)
        {
            res[i] = new int[nums.Length];
        }
        Array.Copy(nums, res[0], nums.Length);
        int pivot = 1;

        while (pivot < fac)
        {
            gretestMobileIndex = GetGreatestMobileIndexAndUpdateMobilities(nis);
            if (nis[gretestMobileIndex].directionLeft)
            {
                (nis[gretestMobileIndex - 1], nis[gretestMobileIndex]) = (nis[gretestMobileIndex], nis[gretestMobileIndex - 1]);
                gretestMobileIndex -= 1;
            }
            else
            {
                (nis[gretestMobileIndex + 1], nis[gretestMobileIndex]) = (nis[gretestMobileIndex], nis[gretestMobileIndex + 1]);
                gretestMobileIndex += 1;
            }
            UpdateDirectionLeft(nis, nis[gretestMobileIndex].value);

            for (int i = 0; i < nums.Length; i++)
            {
                res[pivot][i] = nis[i].value;
            }
            pivot++;
        }

        return res;
    }

    private int GetGreatestMobileIndexAndUpdateMobilities(NumberInfo[] nis)
    {
        int gretestMobileIndex = -1;
        int gretestMobileValue = int.MinValue;

        nis[0].isMobile = !nis[0].directionLeft && nis[0] > nis[1];
        if (nis[0].isMobile)
        {
            gretestMobileIndex = 0;
            gretestMobileValue = nis[0].value;
        }

        for (int i = 1; i < nis.Length - 1; i++)
        {
            nis[i].isMobile = nis[i].directionLeft ? nis[i] > nis[i - 1] : nis[i] > nis[i + 1];
            if (nis[i].isMobile && gretestMobileValue < nis[i].value)
            {
                gretestMobileIndex = i;
                gretestMobileValue = nis[i].value;
            }
        }

        nis[^1].isMobile = nis[^1].directionLeft && nis[^1] > nis[^2];
        if (nis[^1].isMobile && gretestMobileValue < nis[^1].value)
        {
            gretestMobileIndex = nis.Length - 1;
        }

        return gretestMobileIndex;
    }

    private void UpdateDirectionLeft(NumberInfo[] nis, int target)
    {
        for (int i = 0; i < nis.Length; i++)
        {
            if (nis[i].value > target)
            {
                nis[i].directionLeft = !nis[i].directionLeft;
            }
        }
    }

    private static bool CompareGreater(int left, int right)
    {
        return left > right;
    }

    private static bool CompareLess(int left, int right)
    {
        return left < right;
    }
}

Solution sol = new Solution();
int[][] res = sol.PermutationsJohnsonTrotter(1, 2, 3);
foreach (int[] one in res)
{
    Console.WriteLine(string.Join(", ", one));
}
