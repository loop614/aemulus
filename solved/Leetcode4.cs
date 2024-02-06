/*
4. Median of Two Sorted Arrays
Hard
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).
*/
public class Solution {
    public static List<int> combineTwoArrays(int[] nums1, int[] nums2, List<int> combine, int i, int j) {
        int value1 = nums1.Length > i ? nums1[i] : int.MaxValue;
        int value2 = nums2.Length > j ? nums2[j] : int.MaxValue;

        if (value1 < value2 && value1 < int.MaxValue) {
            combine.Add(value1);
            combineTwoArrays(nums1, nums2, combine, ++i, j);
        } else if (value2 < int.MaxValue) {
            combine.Add(value2);
            combineTwoArrays(nums1, nums2, combine, i, ++j);
        }

        return combine;
    }

    public double FindMedianSortedArrays2(int[] nums1, int[] nums2) {
        List<int> combine = combineTwoArrays(nums1, nums2, new List<int>(), 0, 0);
        double median;
        if (combine.Count % 2 == 0) {
            int member1 = combine[(combine.Count - 1) / 2];
            int member2 = combine[((combine.Count - 1) / 2) + 1];
            median = (double)(member1 + member2) / 2;
        } else {
            median = combine[(combine.Count - 1)/ 2];
        }

        return median;
    }

    /*
     * beats 89% by execution time
     * beats 67% by memory usage
     */
    public double FindMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] combine = new int[nums1.Length + nums2.Length];
        int i = 0, j = 0, k = 0;
        while (true) {
            if (i < nums1.Length && j < nums2.Length) {
                if (nums1[i] < nums2[j]) {
                    combine[k] = nums1[i];
                    ++k;
                    ++i;
                    continue;
                } else {
                    combine[k] = nums2[j];
                    ++k;
                    ++j;
                    continue;
                }
            }
            while (i < nums1.Length) {
                combine[k] = nums1[i];
                ++k;
                ++i;
            }
            while (j < nums2.Length) {
                combine[k] = nums2[j];
                ++k;
                ++j;
            }
            break;
        }
        if (k % 2 == 0) {
            return (double)(combine[k / 2] + combine[(k / 2) - 1]) / 2;
        }

        return combine[(k - 1)/ 2];
    }
}

Solution sol = new Solution();
double output;

output = sol.FindMedianSortedArrays([1,3], [2]);
Console.WriteLine(output);
Console.WriteLine(output == 2);

output = sol.FindMedianSortedArrays([1,2], [3,4]);
Console.WriteLine(output);
Console.WriteLine(output == 2.5);
