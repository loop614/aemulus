// public class Main {
//     public static void main(String[] args) {
//         Solution sol = new Solution();
//         String output;
//         output = sol.intToRoman(1);
//         System.out.println(output);
//         System.out.println(output.equals("I"));
//         output = sol.intToRoman(58);
//         System.out.println(output);
//         System.out.println(output.equals("LVIII"));
//         output = sol.intToRoman(22);
//         System.out.println(output);
//         System.out.println(output.equals("XXII"));
//         output = sol.intToRoman(72);
//         System.out.println(output);
//         System.out.println(output.equals("LXXII"));
//         output = sol.intToRoman(99);
//         System.out.println(output);
//         System.out.println(output.equals("XCIX"));
//         output = sol.intToRoman(1994);
//         System.out.println(output);
//         System.out.println(output.equals("MCMXCIV"));
//     }
// }


class Solution {
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
