/*
67. Add Binary
Easy
Given two binary strings a and b, return their sum as a binary string.
 */
public class Leetcode67 {
    public static void main(String[] args) {
        Solution67 sol = new Solution67();
        System.out.println("10101".equals(sol.addBinary("1010", "1011")));
        System.out.println("100".equals(sol.addBinary("11", "1")));
    }
}

class Solution67 {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int lena = a.length(), lenb = b.length(), pivot = lena - 1;
        boolean ro = false;

        if (lena > lenb) {
            b = "0".repeat(lena - lenb) + b;
            pivot = lena - 1;
        } else if (lenb > lena) {
            a = "0".repeat(lenb - lena) + a;
            pivot = lenb - 1;
        }

        while (pivot >= 0) {
            if (a.charAt(pivot) == 49 && b.charAt(pivot) == 49) {
                if (ro) {
                    res.append('1');
                } else {
                    res.append('0');
                    ro = true;
                }
            } else if (a.charAt(pivot) == 49 || b.charAt(pivot) == 49) {
                if (ro) {
                    res.append('0');
                } else {
                    res.append('1');
                }
            } else {
                if (ro) {
                    res.append('1');
                    ro = false;
                } else {
                    res.append('0');
                }
            }
            pivot--;
        }

        if (ro) {
            res.append('1');
        }

        return res.reverse().toString();
    }
}
