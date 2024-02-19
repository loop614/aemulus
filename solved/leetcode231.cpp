/*
231. Power of Two
Easy
Given an integer n, return true if it is a power of two. Otherwise, return false.
An integer n is a power of two, if there exists an integer x such that n == 2x.
*/
#include <iostream>
#include <vector>
#include <math.h>
#include <bitset>

using namespace std;

class Solution {
public:
    /*
     * beats 60% by execution time
     * beats 19% by memory usage
     */
    bool isPowerOfTwo(int n) {
        if (n > 1 && n & 1 == 1) {
            return false;
        }
        int res = 1;
        for (int i = 0; n > res && i < 31; i++) {
            res = pow(2, i);
        }

        return res == n;
    }

    /*
     * beats 40% by execution time
     * beats 40% by memory usage
     */
    bool isPowerOfTwoBitset(int n) {
        if (n < 0) return false;
        bitset<32> binary = bitset<32>(n);
        int count = 0;
        for (size_t i = 0; i < binary.size(); ++i) {
            if (binary[i] == 1) {
                count++;
                if (count > 2) {
                    return false;
                }
            }
        }

        return count == 1;
    }
};

int main()
{
    Solution sol;
    bool res;
    vector<int> number = {-2147483646, -1, 1, 2, 16, 3, 1073741825, 2147483646};
    for (auto n : number)
    {
        res = sol.isPowerOfTwo(n);
        if (res) {cout << n << " is a power of two";}
        else {cout << n << " is not a power of two";}
        cout << endl;
    }
    return 0;
}
