/*
791. Custom Sort String
Medium
You are given two strings order and s. All the characters of order are unique and were sorted in some custom order previously.
Permute the characters of s so that they match the order that order was sorted. More specifically, if a character x occurs before a character y in order, then x should occur before y in the permuted string.
Return any permutation of s that satisfies this property.
*/
public class Solution
{
    public string CustomSortString(string order, string s)
    {
        char[] sc = s.ToArray();
        char[] oc = order.ToArray();
        char temp;
        int leftIndex = 0;

        for(int i = 0; i < oc.Count(); i++) {
            for(int j = leftIndex; j < sc.Count(); j++) {
                if (sc[j] == oc[i]) {
                    temp = sc[leftIndex];
                    sc[leftIndex] = oc[i];
                    sc[j] = temp;
                    leftIndex++;
                }
            }
        }

        return new string(sc);
    }

    public string CustomSortStringNaive(string order, string s)
    {
        string sper = "";
        for(int i = 0; i < order.Count(); i++) {
            for(int j = 0; j < s.Count(); j++) {
                if (s[j] == order[i]) {
                    sper += order[i].ToString();
                }
            }
        }
        bool cons = false;
        string sufix = "";
        for(int i = 0; i < s.Count(); i++) {
            cons = false;
            for(int j = 0; j < sper.Count(); j++) {
                if (sper[j] == s[i]) {
                    cons = true;
                    break;
                }
            }
            if (!cons) {
                sufix += s[i];
            }
        }

        return sper + sufix;
    }
}

Solution sol = new Solution();
string res;
string[] expected;

res = sol.CustomSortString("cba", "abcd");
expected = ["cbad", "dcba", "cdba", "cbda"];
Console.WriteLine(res);
Console.WriteLine(expected.Contains(res));

res = sol.CustomSortString("bcafg", "abcd");
expected = ["bcad", "bacd", "bcda"];
Console.WriteLine(res);
Console.WriteLine(expected.Contains(res));

res = sol.CustomSortString("kqep" , "pekeq");
expected = ["kqeep"];
Console.WriteLine(res);
Console.WriteLine(expected.Contains(res));

res = sol.CustomSortString("hucw", "utzoampdgkalexslxoqfkdjoczajxtuhqyxvlfatmptqdsochtdzgypsfkgqwbgqbcamdqnqztaqhqanirikahtmalzqjjxtqfnh");
expected = [
    "hhhhhuucccwaaaaaaaaabbdddddeffffggggiijjjjkkkkllllmmmmnnnoooopppqqqqqqqqqqqrsssttttttttvxxxxxyyzzzzz",
    "hhhhhuucccwlexslxoqfkdjodzajxtmpqyxvlfatmptqdsogttdzgypsfkgqabgqbkamdqnqztaqzqanirikaotmalzqjjxtqfna"];
Console.WriteLine(res);
Console.WriteLine(expected.Contains(res));
