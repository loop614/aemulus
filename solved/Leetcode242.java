import java.util.Arrays;

// public class Main {
//     public static void main(String[] args) {
//         Solution sol = new Solution();
//         boolean output;
//         output = sol.isAnagram("anagram", "nagaram");
//         System.out.println(output == true);

//         output = sol.isAnagram("rat", "car");
//         System.out.println(output == false);

//         output = sol.isAnagram("a", "ab");
//         System.out.println(output == false);
//     }
// }


class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);

        for(int i = 0; i< sc.length; i++) {
            if (sc[i] != tc[i]) {
                return false;
            }
        }

        return true;
    }
}
