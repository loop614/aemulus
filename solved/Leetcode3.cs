/*
3. Longest Substring Without Repeating Characters
Medium
Given a string s, find the length of the longest substring without repeating characters.
*/

public class Solution {
    /*
     * beats 99% by execution time
     * beats 74% by memory usage
     */
    public int LengthOfLongestSubstring(string s) {
        Queue<char> queue = new();
        int maxSubstring = 0;
        foreach (char letter in s) {
            if (queue.Contains(letter)) {
                if (maxSubstring < queue.Count) {
                    maxSubstring = queue.Count;
                }
                while (queue.Count != 0 && letter != queue.Dequeue()) {
                }
            }
            queue.Enqueue(letter);
        }
        if (maxSubstring < queue.Count) {
            return queue.Count;
        }

        return maxSubstring;
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
