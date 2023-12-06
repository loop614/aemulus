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
    
    public double FindMedianSortedArrays(int[] nums1, int[] nums2) {
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
}
