
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
1190. Reverse Substrings Between Each Pair of Parentheses
Medium
You are given a string s that consists of lower case English letters and brackets.
Reverse the strings in each pair of matching parentheses, starting from the innermost one.
Your result should not contain any brackets.
 */

public class Leetcode1190 {

    public static void main(String[] args) {
        Solution1190 sol = new Solution1190();
        String res;

        res = sol.reverseParentheses("ta()usw((((a))))");
        System.out.println(res);
        System.out.println("tauswa".equals(res));

        res = sol.reverseParentheses("(abcd)");
        System.out.println(res);
        System.out.println("dcba".equals(res));

        res = sol.reverseParentheses("yfgnxf");
        System.out.println(res);
        System.out.println("yfgnxf".equals(res));

        res = sol.reverseParentheses("co(de(fight)s)");
        System.out.println(res);
        System.out.println("cosfighted".equals(res));

        res = sol.reverseParentheses("a(bcdefghijkl(mno)p)q");
        System.out.println(res);
        System.out.println("apmnolkjihgfedcbq".equals(res));

        res = sol.reverseParentheses("(ed(et(oc))el)");
        System.out.println(res);
        System.out.println("leetcode".equals(res));

        res = sol.reverseParentheses("(u(love)i)");
        System.out.println(res);
        System.out.println("iloveu".equals(res));
    }
}

class Solution1190 {

    public String reverseParentheses(String s) {
        Pattern pat = Pattern.compile("\\([a-z]*\\)");
        boolean foundMatches = true;

        while (foundMatches) {
            foundMatches = false;
            Matcher m = pat.matcher(s);
            while (m.find()) {
                foundMatches = true;
                String group = m.group();
                String replacement = "";
                if (group.length() - 2 > 0) {
                    replacement = group.substring(1, group.length() - 1);
                }
                s = s.replace(group, (new StringBuilder(replacement)).reverse().toString());
            }
        }

        return s;
    }
}
