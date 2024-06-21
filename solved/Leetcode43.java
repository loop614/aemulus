/*
43. Multiply Strings
Medium
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
1 <= num1.length, num2.length <= 200
num1 and num2 consist of digits only.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 */

import java.util.Arrays;

public class Leetcode43 {

    public static void main(String... args) {
        Solution43 sol = new Solution43();
        String res;

        res = sol.multiply("123", "456");
        System.out.println(res);
        System.out.println("56088".equals(res));

        res = sol.multiply("789", "456");
        System.out.println(res);
        System.out.println("359784".equals(res));

        res = sol.multiply("789789789789789789789789789789789", "456456456456456456456456456456456456456");
        System.out.println(res);
        System.out.println("360504648792937081225369513657801585585225080936792648504360216071927784".equals(res));
    }
}

class Solution43 {

    public static String addStrings(String[] nums, int maxLength) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = "0".repeat(maxLength - nums[i].length()) + nums[i];
        }

        StringBuilder result = new StringBuilder(maxLength + 1);
        int carry = 0;

        for (int i = maxLength - 1; i >= 0; i--) {
            int sum = 0;
            for (String num : nums) {
                sum += num.charAt(i) - '0';
            }
            sum += carry;
            carry = sum / 10;
            result.append(sum % 10);
        }

        if (carry > 0) {
            result.append(carry);
        }

        return result.reverse().toString();
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        Integer extras = 0;
        String[] multis = new String[num2.length()];
        int multisPivot = 0;
        Arrays.fill(multis, "");
        int suffixZeros = num2.length() - 1;
        int maxLengthMulti = 0;

        for (int j = 0; j < num2.length(); j++) {
            for (int i = num1.length() - 1; i >= 0; i--) {
                Integer sum = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                sum += extras;
                extras = sum / 10;
                multis[multisPivot] = String.valueOf(sum % 10) + multis[multisPivot];
            }
            if (extras > 0) {
                multis[multisPivot] = String.valueOf(extras) + multis[multisPivot];
                extras = 0;
            }

            multis[multisPivot] = multis[multisPivot] + "0".repeat(suffixZeros);
            if (multis[multisPivot].length() > maxLengthMulti) {
                maxLengthMulti = multis[multisPivot].length();
            }
            suffixZeros--;
            multisPivot++;
        }

        return addStrings(multis, maxLengthMulti);
    }
}
