/*
242. Valid Anagram
Easy
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
*/
import java.util.Arrays;

public class Leetcode242 {
    public static void main(String[] args) {
        Solution242 sol = new Solution242();
        boolean output;
        output = sol.isAnagram("anagram", "nagaram");
        System.out.println(output == true);

        output = sol.isAnagram("rat", "car");
        System.out.println(output == false);
    }
}


class Solution242 {
    // best php sol
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int len = s.length();

        int[] sa = new int[26];
        int order, order1;
        for(int i = 0; i < len; i++) {
            order = ((int) s.charAt(i)) -97;
            sa[order]++;
            order1 = ((int) t.charAt(i)) -97;
            sa[order1]--;
        }

        for(int i: sa) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }

    // best java sol
    /*
     * beats 84% by execution time
     * beats 45% by memory usage
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);

        return Arrays.equals(sc, tc);
    }

    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int tl = s.length();
        int sl = tl;
        boolean h;
        String hpos = "";
        for (int i=0; i < sl; i++) {
            h = false;
            for (int j=0; j < tl; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    h = true;
                    hpos = Character.toString(t.charAt(j));
                    break;
                }
            }
            if (h) {
                t = t.replaceFirst(String.join("/", hpos), "");
                tl--;
            }
        }

        return t.length() == 0;
    }
}
