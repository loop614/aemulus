/*
415. Add Strings
Easy
Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.
 */
public class Leetcode415 {

    public static void main(String... args) {
        Solution415 sol = new Solution415();
        String res;

        res = sol.addStrings("123", "456");
        System.out.println(res);
        System.out.println("579".equals(res));
    }
}

class Solution415 {

    public String addStrings(String num1, String num2) {
        int lenDiff = num2.length() - num1.length();
        int maxLength = num2.length();
        if (lenDiff > 0) {
            num1 = "0".repeat(lenDiff) + num1;
        } else if (lenDiff < 0) {
            num2 = "0".repeat(lenDiff * -1) + num2;
            maxLength = num1.length();
        }

        StringBuilder result = new StringBuilder(maxLength + 1);
        int carry = 0;

        for (int i = maxLength - 1; i >= 0; i--) {
            int digit1 = num1.charAt(i) - '0';
            int digit2 = num2.charAt(i) - '0';

            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            result.append(sum % 10);
        }

        if (carry > 0) {
            result.append(carry);
        }

        return result.reverse().toString();
    }
}
