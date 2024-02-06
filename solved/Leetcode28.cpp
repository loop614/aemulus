/*
28. Find the Index of the First Occurrence in a String
Easy
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
*/

#include <iostream>
#include <string>

using namespace std;

class Solution {
public:
    /*
     * beats 44% by execution time
     * beats 68% by memory usage
     */
    int strStr(string haystack, string needle) {
        bool same;
        int pos = -1;
        if (haystack.length() == needle.length()) {
            if(haystack.compare(needle) == 0) {return 0;}
            return -1;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        for(int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack[i] == needle[0]) {
                same = true;
                for (int j = i; j < i+needle.length();j++) {
                    if (haystack[j] != needle[j-i]) {
                        same = false;
                        break;
                    }
                }
                if (same) {pos = i;break;}
            }
        }
        return pos;
    }
};

int main() {
    Solution *sol = new Solution();
    int output;

    output = sol->strStr("baaa", "abbb");
    cout << "2 == ";
    cout << output << endl;

    output = sol->strStr("abb", "abaaa");
    cout << "2 == ";
    cout << output << endl;

    output = sol->strStr("abc", "c");
    cout << "2 == ";
    cout << output << endl;

    output = sol->strStr("a", "a");
    cout << "1 == ";
    cout << output << endl;

    output = sol->strStr("a", "b");
    cout << "-1 == ";
    cout << output << endl;

    output = sol->strStr("leetcode", "tc");
    cout << "3 == ";
    cout << output << endl;

    output = sol->strStr("sadbutsad", "sad");
    cout << "0 == ";
    cout << output << endl;

    output = sol->strStr("leetcode", "leeto");
    cout << "-1 == ";
    cout << output << endl;

    return 0;
}
