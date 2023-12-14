// public class Main {
//     public static void main(String[] args) {
//         Solution sol = new Solution();
//         int output;
//         output = sol.findSpecialInteger(new int[]{1,2,2,6,6,6,6,7,10});
//         System.out.println(output == 6);
//         output = sol.findSpecialInteger(new int[]{1,1});
//         System.out.println(output == 1);
//         output = sol.findSpecialInteger(new int[]{1});
//         System.out.println(output == 1);
//         output = sol.findSpecialInteger(new int[]{1,2,3,3});
//         System.out.println(output == 3);
//         output = sol.findSpecialInteger(new int[]{2,3,3});
//         System.out.println(output == 2);
//     }
// }

class Solution {
    public int findSpecialInteger(int[] arr) {
        int prev = arr[0];
        int occ = 0;
        double q = 0.25 * arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (prev == arr[i]) {
                occ++;
                if (occ > q) {
                    return arr[i];
                }
                continue;
            }
            prev = arr[i];
            occ = 1;
        }

        return 0;
    }
}
