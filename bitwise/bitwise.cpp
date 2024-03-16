#include <iostream>
#include <vector>
#include <math.h>
#include <bitset>

void swapIndexes(int a[], int i, int k)
{
    a[i] ^= a[k];
    a[k] ^= a[i];
    a[i] ^= a[k];
}

int convertToHighestBitValue(int number)
{
    int highestBitPosition = 0;
    while (number > 0) {
        number >>= 1;
        highestBitPosition++;
    }

    return (1 << highestBitPosition - 1);
}

/*
231. Power of Two
https://leetcode.com/problems/power-of-two/
*/
bool isPowerOfTwo(int n) {
    return n&(n-1) == 0;
}

/*
201. Bitwise AND of Numbers Range
https://leetcode.com/problems/bitwise-and-of-numbers-range/description/
TODO:
*/
int rangeBitwiseAnd(int l, int r) {
    int s=0;
    while(l<r) {
        l>>=1;
        r>>=1;
        s++;
    }
    return l<<s;
}

int main()
{
    std::vector<int> a = {1,2,3,4,5,123,332,614};
    for (int i : a) {
        std::cout << i;
        std::cout << " ";
        std::cout << convertToHighestBitValue(i);
        std::cout << std::endl;
    }

    bool res;
    std::vector<int> number = {-2147483646, -1, 1, 2, 16, 3, 1073741825, 2147483646};
    for (auto n : number)
    {
        res = isPowerOfTwo(n);
        if (res) {std::cout << n << " is a power of two";}
        else {std::cout << n << " is not a power of two";}
        std::cout << std::endl;
    }

    std::vector<int> nums = {2147483646, 2147483647, 0, 0, 1, 1 ,2, 2 ,0, 1, 0, 3, 4, 7, 5, 7, 0, 0, 1, 2147483647};
    std::vector<int> ress = {2147483646, 0, 1, 2, 0, 0, 4, 4, 0};
    int out, outCalc;

    for(uint i = 0; i < nums.size(); i+=2) {
        out = rangeBitwiseAnd(nums[i], nums[i+1]);
        std::cout << ress[i/2];
        std::cout << " ";
        std::cout << out;
        std::cout << std::endl;
    }

    int b[] = {1,2};
    swapIndexes(b, 0, 1);
    std::cout << b[0] << b[1] << std::endl;
}
