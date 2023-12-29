import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

// public class Main {
//     public static void main(String[] args) {
//         Solution15 sol = new Solution15();
//         List<List<Integer>> output;

//         output = sol.threeSum(new int[]{1000000000,1000000000,1000000000,1000000000});
//         System.out.println(output);
//         System.out.println("[]");
//         System.out.println(output.size() == 0);

//         output = sol.threeSum(new int[]{0, 5, -8, -7, 4, 8, -4, 3, 9, 7, 8, 10, 3, -6, 3, 7, 10, 0});
//         System.out.println(output);
//         System.out.println("[[-8, -7, -6, 9], [-8, -7, -4, 7], [-8, -7, 0, 3], [-8, -4, 0, 0], [-7, -6, -4, 5]]");
//         System.out.println(output.size() == 5);

//         output = sol.threeSum(new int[]{-2, -1, -1, 1, 1, 2, 2});
//         System.out.println(output);
//         System.out.println("[[-2, -1, 1, 2], [-1, -1, 1, 1]]");
//         System.out.println(output.size() == 2);

//         output = sol.threeSum(new int[]{1, 0, -1, 0, -2, 2});
//         System.out.println(output);
//         System.out.println("[[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]");
//         System.out.println(output.size() == 3);

//         output = sol.threeSum(new int[]{2, 2, 2, 2, 2});
//         System.out.println(output);
//         System.out.println("[[2, 2, 2, 2]]");
//         System.out.println(output.size() == 1);
//     }
// }

class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            int sum = 0;
                while (j < k) {
                    sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0) {
                        List<Integer>bear = new ArrayList<>();
                        bear.add(nums[i]);
                        bear.add(nums[j]);
                        bear.add(nums[k]);
                        Collections.sort(bear);
                        res.add(bear);
                    }
                    if (sum < 0) {
                        j++;
                    } else {
                        k--;
                    }
                }
        }

        return new ArrayList<List<Integer>>(res);
    }
}
