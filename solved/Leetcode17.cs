
public class Solution {

    public IList<string> LetterCombinations(string digits) {
        if (digits.Length == 0) {
            return new List<string>();
        }
        Dictionary<char, char[]> numpad = new()
        {
            {'2', new char[] {'a', 'b', 'c'}},
            {'3', new char[] {'d', 'e', 'f'}},
            {'4', new char[] {'g', 'h', 'i'}},
            {'5', new char[] {'j', 'k', 'l'}},
            {'6', new char[] {'m', 'n', 'o'}},
            {'7', new char[] {'p', 'q', 'r', 's'}},
            {'8', new char[] {'t', 'u', 'v'}},
            {'9', new char[] {'w', 'x', 'y', 'z'}}
        };

        int combCount = 1;
        foreach (char c in digits) {
            combCount *= numpad[c].Length;
        }
        List<string> res = Enumerable.Repeat("", combCount).ToList();
        // 23
        // 'a', 'b', 'c'
        //  a    a    a    b   b   b    c   c   c

        // 'd', 'e', 'f'
        //  d    e    f    d   e   f    d   e   f

        int divisor = 1;

        for (int i = 0; i < digits.Length; i++) {
            divisor *= numpad[digits[i]].Length;
            int div = combCount / divisor;
            int pivotLet = 0;

            int allWay = combCount;
            int pivotRes = 0;

            while (allWay > 0) {
                int count = div;
                while (count > 0) {
                    res[pivotRes] += numpad[digits[i]][pivotLet];
                    count--;
                    allWay--;
                    pivotRes = GetNextIndex(pivotRes, combCount);
                }
                pivotLet = GetNextIndex(pivotLet, numpad[digits[i]].Length);
            }
        }

        return res;
    }

    public IList<string> LetterCombinations2(string digits) {
        if (digits.Length == 0) {
            return new List<string>();
        }
        Dictionary<char, char[]> numpad = new()
        {
            {'2', new char[] {'a', 'b', 'c'}},
            {'3', new char[] {'d', 'e', 'f'}},
            {'4', new char[] {'g', 'h', 'i'}},
            {'5', new char[] {'j', 'k', 'l'}},
            {'6', new char[] {'m', 'n', 'o'}},
            {'7', new char[] {'p', 'q', 'r', 's'}},
            {'8', new char[] {'t', 'u', 'v'}},
            {'9', new char[] {'w', 'x', 'y', 'z'}}
        };

        int combCount = 1;
        foreach (char c in digits) {
            combCount *= numpad[c].Length;
        }
        List<string> res = Enumerable.Repeat("", combCount).ToList();
        // 234
        // 'a', 'b', 'c'
        // 'd', 'e', 'f'
        // 'g', 'h', 'i'

        // adg, adh, adi, aeg, aeh, aei, afg, afh, afi

        // 0 0 0 0 0 0 0 0 0
        // 0 0 0 1 1 1 2 2 2
        // 0 1 2 0 1 2 0 1 2
        int[] posMap = new int[digits.Length];
        Array.Fill(posMap, 0);

        for (int i = 0; i < combCount; i++) {
            for (int k = 0; k < digits.Length; k++) {
                res[i] += numpad[digits[k]][posMap[k]];
            }

            int j = digits.Length - 1;
            while (j >= 0) {
                posMap[j] = GetNextIndex(posMap[j], numpad[digits[j]].Length);
                if (posMap[j] != 0) {
                    break;
                }
                j--;
            }
        }

        return res;
    }

    private int GetNextIndex(int pivot, int arrCount) {
        if (pivot + 1 < arrCount) {
            return pivot+1;
        }
        return 0;
    }
}

Solution sol = new();
IList<string> res;
// a b c
// d e f

res = sol.LetterCombinations("234");
Console.WriteLine(String.Join(",", res));
Console.WriteLine("adg,adh,adi,aeg,aeh,aei,afg,afh,afi,bdg,bdh,bdi,beg,beh,bei,bfg,bfh,bfi,cdg,cdh,cdi,ceg,ceh,cei,cfg,cfh,cfi");

res = sol.LetterCombinations("23");
Console.WriteLine(String.Join(",", res));
Console.WriteLine("ad,ae,af,bd,be,bf,cd,ce,cf");

res = sol.LetterCombinations("67");
Console.WriteLine(String.Join(",", res));
Console.WriteLine("mp,mq,mr,ms,np,nq,nr,ns,op,oq,or,os");

res = sol.LetterCombinations("");
Console.WriteLine(String.Join(",", res));
Console.WriteLine("[]");

res = sol.LetterCombinations("2");
Console.WriteLine(String.Join(",", res));
Console.WriteLine("[a,b,c]");
