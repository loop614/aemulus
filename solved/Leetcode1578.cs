public class Solution
{
    public int MinCost(string colors, int[] neededTime)
    {
        int costSum = 0;
        bool addFirst;
        int currMax;
        for (int i = 0; i<colors.Length-1; i++)
        {
            addFirst = true;
            currMax = 0;
            while (i<neededTime.Length-1 && colors[i] == colors[i+1]) {
                if (addFirst) {
                    currMax = Math.Max(neededTime[i], currMax);
                    costSum += neededTime[i];
                    addFirst = false;
                }
                currMax = Math.Max(neededTime[i+1], currMax);
                costSum += neededTime[i+1];
                i++;
            }
            if (!addFirst) {
                costSum -= currMax;
            }
        }

        return costSum;
    }

    public int MinCost2(string colors, int[] neededTime)
    {
        int costSum = 0;
        List<int> currTimes = new();
        bool addFirst;

        for (int i = 0; i<neededTime.Length-1; i++)
        {
            addFirst = true;
            while (i<neededTime.Length-1 && colors[i] == colors[i+1]) {
                if (addFirst) {
                    currTimes.Add(neededTime[i]);
                    addFirst = false;
                }
                currTimes.Add(neededTime[i+1]);
                i++;
            }
            if (currTimes.Count > 0) {
                currTimes.Sort();
                for (int j = 0; j < currTimes.Count - 1; j++) {
                    costSum += currTimes[j];
                }
                currTimes.Clear();
            }
        }

        return costSum;
    }
}


public class Aemulus {
    public static void Main(String[] args) {
        Solution sol = new();
        int res;
        res = sol.MinCost("aaabbbabbbb", new []{3,5,10,7,5,3,5,5,4,8,1});
        Console.WriteLine(res);
        Console.WriteLine(res == 26);

        res = sol.MinCost("aaaa", new []{5,4,8,1});
        Console.WriteLine(res);
        Console.WriteLine(res == 10);


        res = sol.MinCost("abaac", new []{1,2,3,4,5});
        Console.WriteLine(res);
        Console.WriteLine(res == 3);

        res = sol.MinCost("abc", new []{1,2,3});
        Console.WriteLine(res);
        Console.WriteLine(res == 0);

        res = sol.MinCost("aabaa", new []{1,2,3,4,1});
        Console.WriteLine(res);
        Console.WriteLine(res == 2);
    }
}
