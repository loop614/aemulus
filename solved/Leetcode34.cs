/*
34. Find First and Last Position of Element in Sorted Array
Medium
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.
*/
public class Solution {
    /*
     * beats 87% by execution time
     * beats 45% by memory usage
     */
    public int[] SearchRange(int[] nums, int target) {
        if (nums.Length == 0) {
            return [-1, -1];
        }

        int pivotLeft = 0;
        int pivotRight = nums.Length - 1;
        int pivot = (pivotLeft + pivotRight) / 2;
        while (nums[pivot] != target) {
            if (target > nums[pivot]) {
                pivotLeft = pivot;
            }
            else if(target < nums[pivot]) {
                pivotRight = pivot;
            }

            if (pivotRight - pivotLeft < 2) {
                if (nums[pivotLeft] == target) {
                    pivot = pivotLeft;
                    break;
                }
                if (nums[pivotRight] == target) {
                    pivot = pivotRight;
                    break;
                }

                return [-1, -1];
            }

            pivot = (pivotLeft + pivotRight) / 2;
        }

        pivotLeft = pivot;
        pivotRight = pivot;
        while (pivotLeft-1 >= 0 && nums[pivotLeft-1] == target) {
            pivotLeft--;
        }
        while (pivotRight+1 < nums.Length && nums[pivotRight+1] == target) {
            pivotRight++;
        }

        return [pivotLeft, pivotRight];
    }
}

void PrintArray(int[] ar)
{
    foreach(var one in ar) {
        Console.Write(one);
        Console.Write(" ");
    }
    Console.Write("\n");
}


Solution sol = new Solution();
int[] res;

res = sol.SearchRange([0,0,1,1,1,4,5,5], 5);
Console.WriteLine("6 7");
PrintArray(res);

res = sol.SearchRange([0,0,1,1,1,4,5,5], 0);
Console.WriteLine("0 1");
PrintArray(res);

res = sol.SearchRange([0,0,1,1,1,4,5,5], 2);
Console.WriteLine("-1 -1");
PrintArray(res);

res = sol.SearchRange([5,7,7,8,8,10], 8);
Console.WriteLine("3 4");
PrintArray(res);

res = sol.SearchRange([1, 2, 3], 3);
Console.WriteLine("2 2");
PrintArray(res);

res = sol.SearchRange([1, 4], 4);
Console.WriteLine("1 1");
PrintArray(res);

res = sol.SearchRange([5,7,7,8,8,10], 6);
Console.WriteLine("-1 -1");
PrintArray(res);

res = sol.SearchRange([], 0);
Console.WriteLine("-1 -1");
PrintArray(res);

res = sol.SearchRange([1], 1);
Console.WriteLine("0 0");
PrintArray(res);
