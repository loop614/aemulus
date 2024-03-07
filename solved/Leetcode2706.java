import java.util.Arrays;

/*
2706. Buy Two Chocolates
Easy
You are given an integer array prices representing the prices of various chocolates in a store. You are also given a single integer money, which represents your initial amount of money.
You must buy exactly two chocolates in such a way that you still have some non-negative leftover money. You would like to minimize the sum of the prices of the two chocolates you buy.
Return the amount of money you will have leftover after buying the two chocolates. If there is no way for you to buy two chocolates without ending up in debt, return money. Note that the leftover must be non-negative.
*/
public class Leetcode2706 {
    public static void main(String[] args) {
        Solution2706 sol = new Solution2706();
        int output;
        output = sol.buyChoco(new int[]{1,2,2}, 3);
        System.out.println(output);
        System.out.println(output == 0);
        output = sol.buyChoco(new int[]{3,2,3}, 3);
        System.out.println(output);
        System.out.println(output == 3);
        output = sol.buyChoco(new int[]{98,54,6,34,66,63,52,39}, 62);
        System.out.println(output);
        System.out.println(output == 22);
        output = sol.buyChoco(new int[]{69,91,78,19,40,13}, 94);
        System.out.println(output);
        System.out.println(output == 62);
    }
}


class Solution2706 {
    public int buyChoco(int[] nums, int money) {
        int minVal = 101, minVal2 = 101, exMinVal = 101;
        for(int i = 0; i < nums.length; i++) {
            if (minVal > nums[i]) {
                exMinVal = minVal;
                minVal = nums[i];
                if (minVal2 > exMinVal) {
                    minVal2 = exMinVal;
                }
                continue;
            }
            if (minVal2 > nums[i]) {
                minVal2 = nums[i];
            }
        }
        System.out.println(minVal);
        System.out.println(minVal2);
        int sum = minVal + minVal2;
        return (money >= sum) ? money - sum : money;
    }

    public int buyChoco2(int[] nums, int money) {
        Arrays.sort(nums);
        return (money >= nums[0] + nums[1]) ? money - nums[0] - nums[1] : money;
    }
}
