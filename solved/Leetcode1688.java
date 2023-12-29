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

    public int numberOfMatches(int n) {
         return this.spinAround(n, 0);
    }
}


// public class Main {
//     public static void main(String[] args) {
//         int sol = new Solution().numberOfMatches(14);
//         System.out.println(sol);
//     }
// }
