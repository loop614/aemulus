
public class Solution {
    public bool IsPowerOfThree3(int n) {
        return Math.Log(n, 3) % 1 == 0;
    }

    public bool IsPowerOfThree2(int n) {
        double almost = 1 - Math.Log(n, 3) % 1;
        if (almost == 1 || almost < 0.000000000001) {
            return true;
        }

        return false;
    }

    public bool IsPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }
}

Solution sol = new Solution();
bool res;

res = sol.IsPowerOfThree(1162261466);
Console.WriteLine(res == false);

Console.WriteLine("---------");
res = sol.IsPowerOfThree(2);
Console.WriteLine(res == false);

res = sol.IsPowerOfThree(3);
Console.WriteLine(res == true);

res = sol.IsPowerOfThree(4);
Console.WriteLine(res == false);

Console.WriteLine("---------");
res = sol.IsPowerOfThree(26);
Console.WriteLine(res == false);

res = sol.IsPowerOfThree(27);
Console.WriteLine(res == true);

res = sol.IsPowerOfThree(28);
Console.WriteLine(res == false);

Console.WriteLine("---------");
res = sol.IsPowerOfThree(242);
Console.WriteLine(res == false);

res = sol.IsPowerOfThree(243);
Console.WriteLine(res == true);

res = sol.IsPowerOfThree(244);
Console.WriteLine(res == false);
