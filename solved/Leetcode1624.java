/*
1624. Largest Substring Between Two Equal Characters
Easy
Given a string s, return the length of the longest substring between two equal characters, excluding the two characters. If there is no such substring return -1.
A substring is a contiguous sequence of characters within a string.
*/
public class Leetcode1624 {
    public static void main(String[] args) {
        Solution1624 sol = new Solution1624();
        int output;
        output = sol.maxLengthBetweenEqualCharacters("wwwabcacwccc");
        System.out.println(output);
        System.out.println(output == 7);
        output = sol.maxLengthBetweenEqualCharacters("mgntdygtxrvxjnwksqhxuxtrv");
        System.out.println(output);
        System.out.println(output == 18);
        output = sol.maxLengthBetweenEqualCharacters("aa");
        System.out.println(output);
        System.out.println(output == 0);
        output = sol.maxLengthBetweenEqualCharacters("abca");
        System.out.println(output);
        System.out.println(output == 2);
        output = sol.maxLengthBetweenEqualCharacters("cbaxy");
        System.out.println(output);
        System.out.println(output == -1);
    }
}

class Solution1624 {
    public int maxLengthBetweenEqualCharacters2(String s) {
        int max = -1;
        int[] letters = new int[26];
        int pos;
        for (int i = 0; i < s.length(); i++) {
            pos = s.charAt(i) - 'a';
            if (letters[pos] == 0) {
                letters[pos] = i+1;
            }
            else {
                max = Math.max(i - letters[pos], max);
            }
        }

        return max;
    }

    /*
     * beats 100% by execution time
     * beats 88% by memory usage
     */
    public int maxLengthBetweenEqualCharacters(String s) {
        int slen = s.length();
        if (slen < 3) {
            if (slen == 1) {
                return -1;
            }
            else if (slen == 2) {
                if (s.charAt(0) == s.charAt(1)) {
                    return 0;
                }
                return -1;
            }
        }
        int max = -1;
        char chari;
        for (int i=0; i<slen; i++ ) {
            if (max > slen-i-2) {
                break;
            }
            chari = s.charAt(i);
            for (int j=slen-1; j>i+1; j--) {
                if (chari == s.charAt(j)) {
                    max = Math.max(max, j-i-1);
                }
                if (max > j-i-1) {
                    break;
                }
            }
        }

        return max;
    }
}
