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
