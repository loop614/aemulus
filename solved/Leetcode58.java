/*
58. Length of Last Word
Easy
Given a string s consisting of words and spaces, return the length of the last word in the string.
A word is a maximal substring consisting of non-space characters only.
*/
public class Leetcode58 {
    public static void main(String[] args) {
        Solution58 sol = new Solution58();
        System.out.println(5 == sol.lengthOfLastWord("Hello World"));
        System.out.println(4 == sol.lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(6 == sol.lengthOfLastWord("luffy is still joyboy"));
        System.out.println(0 == sol.lengthOfLastWord("   "));
        System.out.println(4 == sol.lengthOfLastWord("word"));
        System.out.println(4 == sol.lengthOfLastWord("word! "));
        System.out.println(5 == sol.lengthOfLastWord("aword!$# "));
    }
}

class Solution58 {
    public int lengthOfLastWord(String s) {
        int res = 0;
        int i = s.length() - 1;
        while (i >= 0 && !isCharLetter(s.charAt(i))) { i--; }
        while (i >= 0 && isCharLetter(s.charAt(i))) { i--; res++; }

        return res;
    }

    private boolean isCharLetter(char a) {
        return (a >= 41 && a <= 90) || (a >= 97 && a <= 123);
    }
}
