/*
1704. Determine if String Halves Are Alike
Easy

You are given a string s of even length. Split this string into two halves of equal lengths, and let a be the first half and b be the second half.
Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s contains uppercase and lowercase letters.
Return true if a and b are alike. Otherwise, return false.
*/
public class Solution {
    public bool HalvesAreAlike(string s) {
        int slenhalf = s.Length / 2;
        int count = 0;
        char[] vowels = new char[] {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        for(int i =0; i < slenhalf; i++) {
            if (vowels.Contains(s[i])) {
                count++;
            }
            if (vowels.Contains(s[i+slenhalf])) {
                count--;
            }
        }

        return count == 0;
    }
}


String example;
bool output;
Solution sol = new Solution();

example = "book";
output = sol.HalvesAreAlike(example);
Console.WriteLine(output);
Console.WriteLine(output == true);

example = "textbook";
output = sol.HalvesAreAlike(example);
Console.WriteLine(output);
Console.WriteLine(output == false);
