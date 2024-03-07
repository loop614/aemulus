/*
415. Add Strings
Easy
Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.
*/
#include <iostream>
#include <string>
#include <stack>
#include <sstream>

using namespace std;

class Solution {
public:
    string addStrings(string num1, string num2) {
        int count1 = num1.size();
        int count2 = num2.size();
        int roundres = 0;
        stack<char> res;
        bool carryOne = false;
        int nu1, nu2;

        while (count1 != 0 || count2 != 0) {
            nu1 = 0;
            nu2 = 0;
            if (count1 > 0) {
                count1--;
                nu1 = num1[count1] - '0';
            }
            if (count2 > 0) {
                count2--;
                nu2 = num2[count2] - '0';
            }

            roundres = nu1 + nu2;
            if (carryOne) { roundres += 1; carryOne = false; }
            if (roundres > 9) {
                carryOne = true;
                roundres -= 10;
            }
            res.push(roundres + '0');
        }

        if (carryOne) { res.push('1'); }

        string ress;
        while (res.size() > 0) {
            ress.push_back(res.top());
            res.pop();
        }

        return ress;
    }
};

int main()
{
    Solution sol;
    string res;
    string num1 = "1";
    string num2 = "9";
    res = sol.addStrings(num1, num2);
    cout << num1 << "+" << num2 << "=" << res << endl;

    num1 = "10";
    num2 = "91";
    res = sol.addStrings(num1, num2);
    cout << num1 << "+" << num2 << "=" << res << endl;

    num1 = "999";
    num2 = "999";
    res = sol.addStrings(num1, num2);
    cout << num1 << "+" << num2 << "=" << res << endl;

    return 0;
}
