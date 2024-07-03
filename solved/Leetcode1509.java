/*
1509. Minimum Difference Between Largest and Smallest Value in Three Moves
Medium
You are given an integer array nums.
In one move, you can choose one element of nums and change it to any value.
Return the minimum difference between the largest and smallest value of nums after performing at most three moves.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Leetcode1509 {

    public static void main(String[] args) {
        Solution1509 sol = new Solution1509();
        int res;

        res = sol.minDifference(new int[]{1, 5, 0, 10, 14});
        System.out.println(res);
        System.out.println(res == 1);

        res = sol.minDifference(new int[]{82, 81, 95, 75, 20});
        System.out.println(res);
        System.out.println(res == 1);

        res = sol.minDifference(new int[]{6, 6, 0, 1, 1, 4, 6});
        System.out.println(res);
        System.out.println(res == 2);

        res = sol.minDifference(new int[]{5, 3, 2, 4});
        System.out.println(res);
        System.out.println(res == 0);

        res = sol.minDifference(new int[]{3, 100, 20});
        System.out.println(res);
        System.out.println(res == 0);
    }
}

class NumberHolder {

    int x;

    public NumberHolder(int x) {
        this.x = x;
    }
}

class NumberHolderComparator implements Comparator<NumberHolder> {

    @Override
    public int compare(NumberHolder nh1, NumberHolder nh2) {
        return Integer.compare(nh1.x, nh2.x);
    }
}

class Solution1509 {

    public int minDifference(int[] nums) {
        if (nums.length < 5) {
            return 0;
        }

        NumberHolderComparator nhc = new NumberHolderComparator();
        NumberHolder[] maxs = new NumberHolder[4];
        NumberHolder zero = new NumberHolder(nums[0]);
        NumberHolder one = new NumberHolder(nums[1]);
        NumberHolder two = new NumberHolder(nums[2]);
        NumberHolder three = new NumberHolder(nums[3]);
        maxs[0] = zero;
        maxs[1] = one;
        maxs[2] = two;
        maxs[3] = three;
        Arrays.sort(maxs, nhc);

        NumberHolder[] mins = new NumberHolder[4];
        mins[0] = zero;
        mins[1] = one;
        mins[2] = two;
        mins[3] = three;
        Arrays.sort(mins, nhc);

        for (int i = 4; i < nums.length; i++) {
            NumberHolder curr = new NumberHolder(nums[i]);
            if (maxs[3].x < curr.x) {
                maxs[0] = maxs[1];
                maxs[1] = maxs[2];
                maxs[2] = maxs[3];
                maxs[3] = curr;
            } else if (maxs[2].x < curr.x) {
                maxs[0] = maxs[1];
                maxs[1] = maxs[2];
                maxs[2] = curr;
            } else if (maxs[1].x < curr.x) {
                maxs[0] = maxs[1];
                maxs[1] = curr;
            } else if (maxs[0].x < curr.x) {
                maxs[0] = curr;
            }

            if (mins[0].x > curr.x) {
                mins[3] = mins[2];
                mins[2] = mins[1];
                mins[1] = mins[0];
                mins[0] = curr;
            } else if (mins[1].x > curr.x) {
                mins[3] = mins[2];
                mins[2] = mins[1];
                mins[1] = curr;
            } else if (mins[2].x > curr.x) {
                mins[3] = mins[2];
                mins[2] = curr;
            } else if (mins[3].x > curr.x) {
                mins[3] = curr;
            }
        }
        ArrayList<NumberHolder> uniques = new ArrayList<NumberHolder>(Arrays.asList(maxs));
        for (NumberHolder min : mins) {
            if (!uniques.contains(min)) {
                uniques.add(min);
            }
        }

        if (uniques.size() < 5) {
            return 0;
        }

        Collections.sort(uniques, nhc);

        int diff1 = Math.abs(uniques.get(uniques.size() - 1).x - uniques.get(3).x);
        int diff2 = Math.abs(uniques.get(0).x - uniques.get(uniques.size() - 4).x);
        int diff3 = Math.abs(uniques.get(2).x - uniques.get(uniques.size() - 2).x);
        int diff4 = Math.abs(uniques.get(1).x - uniques.get(uniques.size() - 3).x);

        return Math.min(Math.min(diff1, diff2), Math.min(diff3, diff4));
    }
}
