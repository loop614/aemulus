/*
1688. Count of Matches in Tournament
Easy
You are given an integer n, the number of teams in a tournament that has strange rules:
    If the current number of teams is even, each team gets paired with another team. A total of n / 2 matches are played, and n / 2 teams advance to the next round.
    If the current number of teams is odd, one team randomly advances in the tournament, and the rest gets paired. A total of (n - 1) / 2 matches are played, and (n - 1) / 2 + 1 teams advance to the next round.
Return the number of matches played in the tournament until a winner is decided.
*/
public class Leetcode1688 {
    public static void main(String[] args) {
        int sol = new Solution1688().numberOfMatches(14);
        System.out.println(sol);
    }
}

class Solution1688 {
    public int spinAround(int n, int numberOfMatchesPlayed) {
        if (n <= 1) {
            return numberOfMatchesPlayed;
        }
        if (n%2 == 0) {
            return this.spinAround(n / 2 , numberOfMatchesPlayed + n / 2);
        }
        return this.spinAround((n - 1) / 2 + 1, numberOfMatchesPlayed + (n - 1) / 2);
    }

    /*
     * beats 100% by execution time
     * beats 69% by memory usage
     */
    public int numberOfMatches(int n) {
         return this.spinAround(n, 0);
    }
}
