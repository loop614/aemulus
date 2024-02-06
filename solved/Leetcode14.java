/*
14. Longest Common Prefix
Easy
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".
*/
public class Leetcode14 {
    public static void main(String[] args) {
        Solution14 sol = new Solution14();
        String output;
        output = sol.longestCommonPrefix(new String[]{"flower","flow","flight"});
        System.out.println(output);
        System.out.println(output.equals("fl"));
        output = sol.longestCommonPrefix(new String[]{"dog","racecar","car"});
        System.out.println(output);
        System.out.println(output.equals(""));
        output = sol.longestCommonPrefix(new String[]{"a"});
        System.out.println(output);
        System.out.println(output.equals("a"));
        output = sol.longestCommonPrefix(new String[]{""});
        System.out.println(output);
        System.out.println(output.equals(""));
        output = sol.longestCommonPrefix(new String[]{"ab", "a"});
        System.out.println(output);
        System.out.println(output.equals("a"));
    }
}

class Solution14 {
    /*
     * beats 99% by execution time
     * beats 74% by memory usage
     */
    public String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        int pivot = 0;
        char letter;
        int i;

        while(true) {
            if (pivot >= strs[0].length()) {
                break;
            }
            letter = strs[0].charAt(pivot);
            for(i = 1; i < strs.length; i++) {
                if (
                    pivot >= strs[i].length() ||
                    strs[i].charAt(pivot) != letter
                ) {
                    return prefix.toString();
                }
            }
            prefix.append(letter);
            pivot++;
        }

        return prefix.toString();
    }
}
