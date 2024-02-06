/*
20. Valid Parentheses
Easy

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.
*/

#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
public:
    /**
     * beats 100% by execution time
     * beats 55% by memory usage
     */
    bool isValid(string s) {
        vector<char> a;
        char last;
        unordered_map<char,char> btb;
        btb[')'] = '(';
        btb[']'] = '[';
        btb['}'] = '{';
        size_t slen = s.length();

        for (int i = 0; i < slen; i++)
        {
            if (s[i] == ')' || s[i] == '}' || s[i] == ']')
            {
                if (a.empty()) { return false; }
                last = a.back();
                if (last != btb[s[i]]) {
                    return false;
                }
                a.pop_back();
                continue;
            }

            a.push_back(s[i]);
        }

        return a.empty();
    }
};

int main() {
    Solution *sol = new Solution();
    bool output;
    output = sol->isValid("()");
    cout << "True ";
    cout << output << endl;

    output = sol->isValid("()[]{}");
    cout << "True ";
    cout << output << endl;

    output = sol->isValid("(]");
    cout << "False ";
    cout << output << endl;

    return 0;
}
