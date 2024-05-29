/*
69. Sqrt(x)
Easy
Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
You must not use any built-in exponent function or operator.
For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
*/
public class Leetcode69 {
    public static void main(String[] args) {
        Solution69 sol = new Solution69();
        int res;

        res = sol.mySqrt(21473956);
        System.out.println(res == 4634);

        res = sol.mySqrt(8);
        System.out.println(res == 2);

        res = sol.mySqrt(17);
        System.out.println(res == 4);

        res = sol.mySqrt(2);
        System.out.println(res == 1);

        res = sol.mySqrt(0);
        System.out.println(res == 0);

        res = sol.mySqrt(4);
        System.out.println(res == 2);

        res = sol.mySqrt(16);
        System.out.println(res == 4);
    }
}

class Solution69 {
    public int mySqrt(int x) {
        int l = 0, r = 46341;
        if (x > Integer.MAX_VALUE / 100) {
            l = 4634;
            if (x > Integer.MAX_VALUE / 2) {
                l = 32767;
            }
        }
        else if (x < Integer.MAX_VALUE / 2) {
            r = 32768;
            if (x < Integer.MAX_VALUE / 100) {
                r = 4635;
            }
        }
        int c, p = 0;
        while (r - l > 1) {
            p = (l + r) / 2;
            c = p * p;
            if (c > x) {
                r = p;
            }
            else if (x > c) {
                l = p;
            }
            else {
                return p;
            }
        }

        return (l + r) / 2;
    }

    public int naiveMySqrt(int x) {
        int p = 1;
        int c;
        if (x > Integer.MAX_VALUE / 100) {
            p = 4634;
            if (x > Integer.MAX_VALUE / 2) {
                p = 32767;
            }
        }
        while (true) {
            c = p*p;
            if (c > x || c < 0) {
                p--;
                break;
            }

            p++;
        }

        return p;
    }
}
