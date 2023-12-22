#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
public:
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
