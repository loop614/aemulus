/*
12. Integer to Roman
Medium
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.

Given an integer, convert it to a roman numeral.
*/
public class Leetcode12 {
    public static void main(String[] args) {
        Solution12 sol = new Solution12();
        String output;
        output = sol.intToRoman(1);
        System.out.println(output);
        System.out.println(output.equals("I"));
        output = sol.intToRoman(58);
        System.out.println(output);
        System.out.println(output.equals("LVIII"));
        output = sol.intToRoman(22);
        System.out.println(output);
        System.out.println(output.equals("XXII"));
        output = sol.intToRoman(72);
        System.out.println(output);
        System.out.println(output.equals("LXXII"));
        output = sol.intToRoman(99);
        System.out.println(output);
        System.out.println(output.equals("XCIX"));
        output = sol.intToRoman(1994);
        System.out.println(output);
        System.out.println(output.equals("MCMXCIV"));
    }
}

class Solution12 {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        while (num >= 1000) {
            sb.append("M");
            num -= 1000;
        }
        if (num >= 900) {
            sb.append("CM");
            num -= 900;
        }
        if (num >= 500) {
            sb.append("D");
            num -= 500;
        }
        if (num >= 400) {
            sb.append("CD");
            num -= 400;
        }
        while (num >= 100) {
            sb.append("C");
            num -= 100;
        }
        if (num >= 90) {
            sb.append("XC");
            num -= 90;
        }
        while (num >= 50) {
            sb.append("L");
            num -= 50;
        }
        if (num >= 40) {
            sb.append("XL");
            num -= 40;
        }
        while (num >= 10) {
            sb.append("X");
            num -= 10;
        }
        while (num >= 9) {
            sb.append("IX");
            num -= 9;
        }
        while (num >= 5) {
            sb.append("V");
            num -= 5;
        }
        if (num >= 4) {
            sb.append("IV");
            num -= 4;
        }
        while (num >= 1) {
            sb.append("I");
            num -= 1;
        }
        return sb.toString();
    }
}
