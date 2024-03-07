/*
29. Divide Two Integers
Medium
Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.
Return the quotient after dividing dividend by divisor.
Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−2^31, 2^31 − 1]. For this problem, if the quotient is strictly greater than 2^31 - 1, then return 2^31 - 1, and if the quotient is strictly less than -2^31, then return -2^31.
*/
public class Solution {
    public int Divide(int dividend, int divisor) {
        if (dividend == 0) { return 0; }
        if (divisor == 1) { return dividend; }
        else if (divisor == -1) {
            if( dividend > 0) {
                return 0-dividend;
            }
            if (dividend == int.MinValue) {
                return int.MaxValue;
            }
            int dividend0Abs = Math.Abs(dividend);
            return dividend+dividend0Abs+dividend0Abs;
        }

        bool isNegative = (divisor < 0 && dividend > 0) || (divisor > 0 && dividend < 0);
        long leftAbs = Math.Abs((long)dividend);
        long rightAbs = Math.Abs((long)divisor);
        long rightAbsCopy = rightAbs;
        int res;
        int count = 1;
        while (leftAbs > rightAbs) {
            leftAbs = leftAbs - rightAbs;
            rightAbs = rightAbs + rightAbs;
            count = count + count;
        }
        res = count - 1;

        while(leftAbs >= rightAbsCopy) {
            leftAbs -= rightAbsCopy;
            res += 1;
        }

        if (isNegative) {
            return 0-res;
        }

        return res;
    }

    public int Divide2(int dividend, int divisor) {
        if (dividend == 0) { return 0; }
        else if (divisor == 1) { return dividend; }
        else if (divisor == -1) {
            if( dividend > 0) {
                return 0-dividend;
            }
            if (dividend == int.MinValue) {
                return int.MaxValue;
            }
            int divident0Abs = Math.Abs(dividend);
            return dividend+divident0Abs+divident0Abs;
        }

        bool isNegative = (divisor < 0 && dividend > 0) || (divisor > 0 && dividend < 0);
        int dividendAbs;
        int divisorAbs;
        bool dividendRememberOne;

        if (dividend != int.MinValue && divisor != int.MinValue) {
            dividendAbs = Math.Abs(dividend);
            divisorAbs = Math.Abs(divisor);
            dividendRememberOne = false;
        } else if (dividend == int.MinValue && divisor != int.MinValue) {
            dividendAbs = int.MaxValue;
            divisorAbs = Math.Abs(divisor);
            dividendRememberOne = true;
        } else if (dividend == int.MinValue && divisor == int.MinValue) {
            dividendAbs = int.MaxValue;
            divisorAbs = int.MaxValue;
            dividendRememberOne = true;
        } else if (divisor == int.MinValue) {
            return 0;
        } else {
            dividendAbs = Math.Abs(dividend);
            divisorAbs = int.MaxValue;
            dividendRememberOne = false;
        }

        int res = 0;
        if(dividendAbs >= divisorAbs) {
            dividendAbs -= divisorAbs;
            res += 1;
        }

        if (dividendRememberOne) {
            dividendAbs+=1;
        }

        int divisor2 = divisorAbs + divisorAbs;
        if (divisor2 > 0) {
            int divisor4 = divisor2 + divisor2;
            if (divisor4 > 0) {
                int divisor8 = divisor4 + divisor4;
                if (divisor8 > 0) {
                    while(dividendAbs >= divisor8) {
                        dividendAbs -= divisor8;
                        res += 8;
                    }
                }
            }
        }

        while(dividendAbs >= divisorAbs) {
            dividendAbs -= divisorAbs;
            res += 1;
        }

        if (res < 0) {
            res = int.MaxValue;
            if (isNegative) {
                return int.MinValue;
            }
        }

        if (isNegative) {
            return 0-res;
        }

        return res;
    }
}

var sol = new Solution();
int res;

res = sol.Divide(int.MinValue, -1);
Console.WriteLine(res);
Console.WriteLine(res == int.MaxValue);

res = sol.Divide(1080358586, 1174041879);
Console.WriteLine(res);
Console.WriteLine(res == 0);

res = sol.Divide(10, 3);
Console.WriteLine(res);
Console.WriteLine(res == 3);

res = sol.Divide(int.MinValue, int.MinValue);
Console.WriteLine(res);
Console.WriteLine(res == 1);

res = sol.Divide(-1, -1);
Console.WriteLine(res);
Console.WriteLine(res == 1);

res = sol.Divide(int.MinValue, -1);
Console.WriteLine(res);
Console.WriteLine(res == int.MaxValue);

res = sol.Divide(int.MinValue, int.MaxValue);
Console.WriteLine(res);
Console.WriteLine(res == -1);

res = sol.Divide(int.MaxValue, int.MinValue);
Console.WriteLine(res);
Console.WriteLine(res == 0);

res = sol.Divide(0, 1);
Console.WriteLine(res);
Console.WriteLine(res == 0);

res = sol.Divide(int.MinValue, 1);
Console.WriteLine(res);
Console.WriteLine(res == int.MinValue);

res = sol.Divide(int.MinValue, 2);
Console.WriteLine(res);
Console.WriteLine(res == -1073741824);

res = sol.Divide(int.MinValue, int.MinValue);
Console.WriteLine(res);
Console.WriteLine(res == 1);

res = sol.Divide(1, int.MinValue);
Console.WriteLine(res);
Console.WriteLine(res == 0);

res = sol.Divide(10, 3);
Console.WriteLine(res);
Console.WriteLine(res == 3);

res = sol.Divide(7, -3);
Console.WriteLine(res);
Console.WriteLine(res == -2);
