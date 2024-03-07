/*
2149. Rearrange Array Elements by Sign
Medium
You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.
You should rearrange the elements of nums such that the modified array follows the given conditions:
    Every consecutive pair of integers have opposite signs.
    For all integers with the same sign, the order in which they were present in nums is preserved.
    The rearranged array begins with a positive integer.
Return the modified array after rearranging the elements to satisfy the aforementioned conditions.
*/
public class Solution {
    public int[] RearrangeArray(int[] nums) {
        Queue<int> negatives = new();
        Queue<int> positives = new();
        int[] res = new int[nums.Length];
        int j = 0;
        for (int i = 0; i < nums.Length; i++) {
            if ((j & 1) == 1 && nums[i] < 0 ) {
                res[j] = nums[i];
                j++;
                if (positives.Count > 0) {
                    res[j] = positives.Dequeue();
                    j++;
                }
                continue;
            } else if ((j & 1) == 0 && nums[i] > 0) {
                res[j] = nums[i];
                j++;
                if (negatives.Count > 0) {
                    res[j] = negatives.Dequeue();
                    j++;
                }
                continue;
            }
            if (nums[i] > 0) {
                positives.Enqueue(nums[i]);
            }
            if (nums[i] < 0) {
                negatives.Enqueue(nums[i]);
            }
        }

        while (positives.Count > 0) {
            res[j] = positives.Dequeue();
            j++;
        }
        while (negatives.Count > 0) {
            res[j] = negatives.Dequeue();
            j++;
        }

        return res;
    }

    public int[] RearrangeArrayUsingArray(int[] nums) {
        int[] negatives = new int[nums.Length];
        int[] positives = new int[nums.Length];
        int countNegatives = 0;
        int countPositives = 0;
        for (int i = 0; i < nums.Length; i++) {
            if (nums[i] > 0) {
                positives[countPositives] = nums[i];
                countPositives++;
            }
            if (nums[i] < 0) {
                negatives[countNegatives] = nums[i];
                countNegatives++;
            }
        }

        countNegatives = 0;
        countPositives = 0;
        for (int i = 0; i < nums.Length; i++) {
            if ((i & 1) == 1 && negatives[countNegatives] != 0) {
                nums[i] = negatives[countNegatives];
                countNegatives++;
                continue;
            } else if (positives[countPositives] != 0) {
                nums[i] = positives[countPositives];
                countPositives++;
                continue;
            }
            if (negatives[countNegatives] == 0) {
                while (positives[countPositives] != 0) {
                    nums[i] = positives[countPositives];
                    countPositives++;
                    i++;
                }
                break;
            }
            if (positives[countPositives] != 0) {
                while (negatives[countNegatives] != 0) {
                    nums[i] = negatives[countNegatives];
                    countNegatives++;
                    i++;
                }
                break;
            }
        }

        return nums;
    }

    public int[] RearrangeArrayUsingList(int[] nums) {
        List<int> negatives = [];
        List<int> positives = [];
        for (int i = 0; i < nums.Length; i++) {
            if (nums[i] > 0) {
                positives.Add(nums[i]);
            }
            if (nums[i] < 0) {
                negatives.Add(nums[i]);
            }
        }
        int countNegatives = 0;
        int countPositives = 0;
        for (int i = 0; i < nums.Length; i++) {
            if ((i & 1) == 1 && countNegatives < negatives.Count) {
                nums[i] = negatives[countNegatives];
                countNegatives++;
                continue;
            } else if (countPositives < positives.Count) {
                nums[i] = positives[countPositives];
                countPositives++;
                continue;
            }
            if (countNegatives == negatives.Count) {
                while (countPositives < positives.Count) {
                    nums[i] = positives[countPositives];
                    countPositives++;
                    i++;
                }
                break;
            }
            if (countPositives == positives.Count) {
                while (countNegatives < negatives.Count) {
                    nums[i] = negatives[countNegatives];
                    countNegatives++;
                    i++;
                }
                break;
            }
        }

        return nums;
    }
}

private static void PrintArray( int[] res )
{
    foreach( int one in res ) {
        Console.Write(one);
        Console.Write(" ");
    }
    Console.WriteLine();
}

private static bool AreArraysSame( int[] arr1, int[] arr2 )
{
    if (arr1.Length != arr2.Length) return false;
    for (int i = 0; i < arr1.Length; i++) {
        if (arr1[i] != arr2[i]) {
            return false;
        }
    }

    return true;
}

Solution sol = new();
int[] input;
int[] result;
int[] expected;

input = [28, -41, 22, -8, -37, 46, 35, -9, 18, -6, 19, -26, -37, -10, -9, 15, 14, 31];
expected = [28, -41, 22, -8, 46, -37, 35, -9, 18, -6, 19, -26, 15, -37, 14, -10, 31, -9];
result = sol.RearrangeArray(input);
PrintArray(result);
PrintArray(expected);
Console.WriteLine(AreArraysSame(result, expected));

input = [3, 1, -2, -5, 2, 4];
expected = [3, -2, 1, -5, 2, 4];
result = sol.RearrangeArray(input);
PrintArray(result);
PrintArray(expected);
Console.WriteLine(AreArraysSame(result, expected));

input = [-1, 1];
expected = [1, -1];
result = sol.RearrangeArray(input);
PrintArray(result);
PrintArray(expected);
Console.WriteLine(AreArraysSame(result, expected));

input = [3, 1, -2, -5, 2, -4];
expected = [3, -2, 1, -5, 2, -4];
result = sol.RearrangeArray(input);
PrintArray(result);
PrintArray(expected);
Console.WriteLine(AreArraysSame(result, expected));
