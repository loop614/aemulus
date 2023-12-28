public class Solution {
    public int LengthOfLongestSubstring(string s) {
        string currentLogestSub = "";
        string longestSub = "";
        foreach (char letter in s) {
            if (!currentLogestSub.Contains(letter.ToString())) {
                currentLogestSub += letter.ToString();
            } else {
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
        }

        return longestSub.Length > currentLogestSub.Length ? longestSub.Length : currentLogestSub.Length;
    }
}
