#nullable enable
/*
 73.88%
 32.89%
*/
public class Solution {
    public IList<IList<string>> GroupAnagrams(string[] strs) {
        List<IList<string>> res = [];
        Dictionary<string, List<string>> combs = [];
        foreach(string str in strs) {
            string sorted = SortString(str);
            if (!combs.TryGetValue(sorted, out List<string>? value)) {
                value = ([]);
                combs[sorted] = value;
            }

            value.Add(str);
        }

        foreach(string key in combs.Keys) {
            res.Add(combs[key]);
        }

        return res;
    }

    private static string SortString(string input)
    {
        char[] characters = input.ToArray();
        Array.Sort(characters);
        return new string(characters);
    }

    public static void PrintMatrix(IList<IList<string>> res)
    {
        foreach(var one in res) {
            foreach(var second in one) {
                Console.Write(second);
                Console.Write(" ");
            }
            Console.Write("\n");
        }
    }
}

var sol = new Solution();
IList<IList<string>> res;

res = sol.GroupAnagrams(["eat","tea","tan","ate","nat","bat"]);
Console.WriteLine("[['bat'],['nat','tan'],['ate','eat','tea']]");
Solution.PrintMatrix(res);

res = sol.GroupAnagrams([""]);
Console.WriteLine("[['']]");
Solution.PrintMatrix(res);

res = sol.GroupAnagrams(["a"]);
Console.WriteLine("[['a']]");
Solution.PrintMatrix(res);
