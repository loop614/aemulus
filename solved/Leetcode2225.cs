/*
2225. Find Players With Zero or One Losses
Medium
You are given an integer array matches where matches[i] = [winneri, loseri] indicates that the player winneri defeated player loseri in a match.
Return a list answer of size 2 where:
    answer[0] is a list of all players that have not lost any matches.
    answer[1] is a list of all players that have lost exactly one match.
The values in the two lists should be returned in increasing order.
Note:
    You should only consider the players that have played at least one match.
    The testcases will be generated such that no two matches will have the same outcome.
*/
#nullable enable

class PlayerDetails {
    public int won;
    public int lost;

    public PlayerDetails() {
        won = 0;
        lost = 0;
    }
}


class Solution {
    public IList<IList<int>> FindWinners2(int[][] matches) {
        List<IList<int>> res = new();
        List<int> winners = new();
        List<int> oneLosers = new();
        int[] losersAr = new int [matches.Length];
        int[] winnersAr = new int [matches.Length];

        for(int i = 0; i < matches.Length; i++) {
            winnersAr[i] = matches[i][0];
            losersAr[i] = matches[i][1];
        }

        Array.Sort(losersAr);
        Array.Sort(winnersAr);
        int cur;

        for(int i = 0; i < winnersAr.Length; i++) {
            cur = winnersAr[i];
            if (!losersAr.Contains(winnersAr[i])) {
                winners.Add(winnersAr[i]);
            }

            while (i < winnersAr.Length - 1 && cur == winnersAr[i+1]) {
                i++;
            }
        }

        bool add;
        for(int i = 0; i < losersAr.Length; i++) {
            cur = losersAr[i];
            add = true;
            while (i < losersAr.Length - 1 && cur == losersAr[i+1]) {
                i++;
                add = false;
            }
            if (add) { oneLosers.Add(cur); }
        }

        res.Add(winners);
        res.Add(oneLosers);

        return res;
    }

    /*
     * beats 52% by execution time
     * beats 80% by memory usage
     */
    public IList<IList<int>> FindWinners(int[][] matches) {
        List<IList<int>> res = [];
        List<int> winners = [];
        List<int> oneLosers = [];
        Dictionary<int, PlayerDetails> data = new();

        for(int i = 0; i < matches.Length; i++) {
            if (!data.TryGetValue(matches[i][0], out PlayerDetails? valueWon)) {
                valueWon = new PlayerDetails();
                data[matches[i][0]] = valueWon;
            }
            if (!data.TryGetValue(matches[i][1], out PlayerDetails? valueLost)) {
                valueLost = new PlayerDetails();
                data[matches[i][1]] = valueLost;
            }
            valueLost.lost++;
            valueWon.won++;
        }

        foreach(int key in data.Keys) {
            if (data[key].lost == 1) {
                oneLosers.Add(key);
            }
            if (data[key].lost == 0 && data[key].won > 0) {
                winners.Add(key);
            }
        }
        winners.Sort();
        oneLosers.Sort();
        res.Add(winners);
        res.Add(oneLosers);

        return res;
    }
}

Solution sol = new Solution();
IList<IList<int>> output;
output = sol.FindWinners([[1,3], [2,3], [3,6], [5,6], [5,7], [4,5], [4,8], [4,9], [10,4], [10,9]]);
foreach ( IList<int> lihne in output ) {
    foreach ( int one in lihne ) {
        Console.Write(one);
        Console.Write(" ");
    }
    Console.Write("\n");
}
Console.WriteLine("[[1,2,10],[4,5,7,8]]");

output = sol.FindWinners([[2,3], [1,3], [5,4],[6,4]]);
foreach ( IList<int> lihne in output ) {
    foreach ( int one in lihne ) {
        Console.Write(one);
        Console.Write(" ");
    }
    Console.Write("\n");
}
Console.WriteLine("[[1,2,5,6],[]]");
