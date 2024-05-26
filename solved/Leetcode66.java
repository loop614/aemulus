/*
66. Plus One
Easy
You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
Increment the large integer by one and return the resulting array of digits.
*/
import java.util.Arrays;

public class Leetcode66 {
    public static void main(String[] args) {
        Solution66 sol = new Solution66();
        System.out.println(Arrays.equals(new int[] {1,2,3}, sol.plusOne(new int[] {1,2,2})));
        System.out.println(Arrays.equals(new int[] {1,3,0}, sol.plusOne(new int[] {1,2,9})));
        System.out.println(Arrays.equals(new int[] {1,0,0}, sol.plusOne(new int[] {9,9})));
        System.out.println(Arrays.equals(new int[] {1,0}, sol.plusOne(new int[] {9})));
    }
}


class Solution66 {
    public int[] plusOne(int[] digits) {
        int lastIndex = digits.length - 1;
        if (digits[lastIndex] != 9) {
            digits[lastIndex]++;
            return digits;
        }

        for (int i = lastIndex; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            if (digits[i] == 9) {
                digits[i] = 0;
                if (i == 0) {
                    int[] resDigits = new int[digits.length + 1];
                    resDigits[0] = 1;
                    System.arraycopy(digits, 0, resDigits, 1, digits.length);
                    return resDigits;
                }
            }
        }

        return digits;
    }
}
