public class Solution {
    public int LengthOfLongestSubstring(string s) {
        string currentLogestSub = "";
        string longestSub = "";
        foreach (char letter in s) {
            if (!currentLogestSub.Contains(letter.ToString())) {
                currentLogestSub += letter.ToString();
                continue;
            }

            if (currentLogestSub.Length > longestSub.Length) {
                longestSub = currentLogestSub;
            }
            foreach (char letter2 in currentLogestSub) {
                if (currentLogestSub.Length == 1) {
                    break;
                }
                currentLogestSub = currentLogestSub.Remove(0, 1);
                if (letter2 == letter) {
                    break;
                }
            }
            if (!currentLogestSub.Contains(letter.ToString())) {
                currentLogestSub += letter.ToString();
            }
        }

        return longestSub.Length > currentLogestSub.Length ? longestSub.Length : currentLogestSub.Length;
    }
}

Solution sol = new Solution();
int output;

output = sol.LengthOfLongestSubstring("abcabcbb");
Console.WriteLine(output);
Console.WriteLine(output == 3);

output = sol.LengthOfLongestSubstring("bbbbb");
Console.WriteLine(output);
Console.WriteLine(output == 1);

output = sol.LengthOfLongestSubstring("pwwkew");
Console.WriteLine(output);
Console.WriteLine(output == 3);
