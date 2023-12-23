public class Solution {
    public bool IsPathCrossing(string path) {
        int x = 0, y = 0;
        List<int> allx = new();
        List<int> ally = new();
        foreach (char c in path) {
            allx.Add(x);
            ally.Add(y);

            // switch takes 56ms
            // if elses take 53ms
            if (c == 'N') {
                y++;
            }
            else if (c == 'W') {
                x--;
            }
            else if (c == 'E') {
                x++;
            }
            else {
                y--;
            }
            for (var i = 0; i < allx.Count; i++) {
                if (allx[i] == x && ally[i] == y) {
                    return true;
                }
            }
        }

        return false;
    }
}


public class Aemulus {
    public static void Main(String[] args) {
        Solution sol = new();
        bool res;
        String input = "NES";
        res = sol.IsPathCrossing(input);
        Console.Write(false == res);
        Console.Write("\n");

        input = "NESWW";
        res = sol.IsPathCrossing(input);
        Console.Write(res == true);
        Console.Write("\n");
    }
}
