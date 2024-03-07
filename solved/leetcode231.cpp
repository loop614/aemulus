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
    bool isPowerOfTwo(int n) {
        vector<int> allNumbers = {1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,131072,262144,524288,1048576,2097152,4194304,8388608,16777216,33554432,67108864,134217728,268435456,536870912,1073741824};
        int leftIndex = 0;
        int rightIndex = allNumbers.size();
        while (leftIndex < rightIndex) {
            int index = (leftIndex+rightIndex) / 2;
            if (n > allNumbers[index]) {
                leftIndex = index + 1;
            } else if (n == allNumbers[index]){
                return true;
            } else {
                rightIndex = index;
            }
        }

        return false;
    }

    bool isPowerOfTwoCalc(int n) {
        if (n > 1 && n & 1 == 1) {
            return false;
        }
        int res = 1;
        for (int i = 0; n > res && i < 31; i++) {
            res = pow(2, i);
        }

        return res == n;
    }

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
