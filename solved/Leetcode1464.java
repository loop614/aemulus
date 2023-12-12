import java.util.Arrays;

// public class Main {
//     public static void main(String[] args) {
//         Solution sol = new Solution();
//         int output;
//         output = sol.maxProduct(new int[]{3,4,5,2});
//         System.out.println(output);
//         System.out.println(output == 12);
//         output = sol.maxProduct(new int[]{1,5,4,5});
//         System.out.println(output);
//         System.out.println(output == 16);
//     }
// }

class Quick
{
    int partition (int a[], int start, int end)
    {
        int pivot = a[end];
        int i = (start - 1);

        for (int j = start; j <= end - 1; j++)
        {
            if (a[j] > pivot)
            {
                i++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[i+1];
        a[i+1] = a[end];
        a[end] = t;
        return (i + 1);
    }

    void quick(int a[], int start, int end)
    {
        if (start < end)
        {
            int p = partition(a, start, end);
            quick(a, start, p - 1);
            quick(a, p + 1, end);
        }
    }
}


class Solution {
    public int maxProduct2(int[] nums) {
        double max = 0;
        double curr = 0;
        int nlen = nums.length;

        for(int i = 0; i < nlen; i++) {
            for(int j = i + 1; j < nlen; j++) {
                curr = (nums[i]-1)*(nums[j]-1);
                if (curr > max) {
                    max = curr;
                }
            }
        }

        return (int) max;
    }

    public int maxProduct1(int[] nums) {
        int nlen = nums.length - 1;
        Quick q1 = new Quick();
        q1.quick(nums, 0, nlen);

        return (nums[0]-1)*(nums[1]-1);
    }

    public int maxProduct(int[] nums) {
        int nlen = nums.length - 1;
        Arrays.sort(nums);

        return (nums[nlen]-1)*(nums[nlen-1]-1);
    }
}
