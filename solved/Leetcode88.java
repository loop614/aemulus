/*
88. Merge Sorted Array
Easy
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
Merge nums1 and nums2 into a single array sorted in non-decreasing order.
The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
*/
import java.util.Arrays;

public class Leetcode88 {
    public static void main(String[] args) {
        Solution88 sol = new Solution88();
        int[] example = {1,2,3,0,0,0};
        int[] example2 = {2,5,6};
        sol.merge(example, 3, example2, 3);
        System.out.println(Arrays.toString(example));

        int[] example3 = {2,0};
        int[] example4 = {1};
        sol.merge(example3, 1, example4, 1);
        System.out.println(Arrays.toString(example3));
    }
}

class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        int[] res = new int[nums1.length];
        int pivot = 0;
        int pivot1 = 0;
        int pivot2 = 0;
        while(true) {
            if (pivot1 < m && pivot2 < n) {
                if (nums1[pivot1] < nums2[pivot2]) {
                    res[pivot] = nums1[pivot1];
                    pivot1++;
                } else {
                    res[pivot] = nums2[pivot2];
                    pivot2++;
                }
            } else if (pivot2 < n) {
                while (pivot2 < n) {
                    res[pivot] = nums2[pivot2];
                    pivot2++;
                    pivot++;
                }
                break;
            } else {
                while (pivot1 < m) {
                    res[pivot] = nums1[pivot1];
                    pivot1++;
                    pivot++;
                }
                break;
            }

            pivot++;
        }

        System.arraycopy( res, 0, nums1, 0, res.length );
    }
}
