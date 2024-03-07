/*
1758. Minimum Changes To Make Alternating Binary String
Easy
You are given a string s consisting only of the characters '0' and '1'. In one operation, you can change any '0' to '1' or vice versa.
The string is called alternating if no two adjacent characters are equal. For example, the string "010" is alternating, while the string "0100" is not.
Return the minimum number of operations needed to make s alternating.
*/
public class Solution {
    // 40ms
    public int MinOperations(string target) {
        int operationsZero = 0, operationsOne = 0;
        for (int i = 0; i < target.Length; i++) {
            if (i % 2 == 0) {
                if (target[i] == '1') {
                    operationsZero++;
                }
                else {
                    operationsOne++;
                }
            }
            else {
                if (target[i] == '1') {
                    operationsOne++;
                }
                else {
                    operationsZero++;
                }
            }
        }
        return operationsOne < operationsZero ? operationsOne : operationsZero;
    }

    // 48ms
    public int MinOperations2(string target) {
        int operationsZero = 0, operationsOne = 0;
        for (int i = 0; i < target.Length; i+=2) {
            if (target[i] == '1') {
                operationsZero++;
            }
            else {
                operationsOne++;
            }
        }

        for (int i = 1; i < target.Length; i+=2) {
            if (target[i] == '1') {
                operationsOne++;
            }
            else {
                operationsZero++;
            }
        }

        return operationsOne < operationsZero ? operationsOne : operationsZero;
    }
}

Solution sol = new();
int res;

res = sol.MinOperations("0100");
Console.WriteLine(res);
Console.WriteLine(res == 1);

res = sol.MinOperations("10");
Console.WriteLine(res);
Console.WriteLine(res == 0);

res = sol.MinOperations("1111");
Console.WriteLine(res);
Console.WriteLine(res == 2);
