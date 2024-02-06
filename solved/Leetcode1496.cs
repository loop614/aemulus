/*
1496. Path Crossing
Easy
Given a string path, where path[i] = 'N', 'S', 'E' or 'W', each representing moving one unit north, south, east, or west, respectively. You start at the origin (0, 0) on a 2D plane and walk on the path specified by path.
Return true if the path crosses itself at any point, that is, if at any time you are on a location you have previously visited. Return false otherwise.
*/
public class Solution {
    /*
     * beats 78% by execution time
     * beats 72% by memory usage
     */
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
