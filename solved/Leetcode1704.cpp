#include <iostream>

/*
1704. Determine if String Halves Are Alike
Easy

You are given a string s of even length. Split this string into two halves of equal lengths, and let a be the first half and b be the second half.
Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s contains uppercase and lowercase letters.
Return true if a and b are alike. Otherwise, return false.
*/

using namespace std;

class Solution {
public:
    /*
     * beats 100% by execution time
     * beats 51% by memory usage
     */
    bool halvesAreAlike(string s) {
        int slenhalf = s.length() / 2;
        int count = 0;
        char vowels[10] = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

        for(int i = 0; i < slenhalf; i++) {
            for (int j = 0; j < 10; j++) {
                if (vowels[j] == s[i]) {
                    count++;
                    break;
                }
            }
            for (int j = 0; j < 10; j++) {
                if (vowels[j] == s[i+slenhalf]) {
                    count--;
                    break;
                }
            }
        }

        return count == 0;
    }
};

int main() {
    string example;
    bool output;
    Solution *sol = new Solution();

    example = "book";
    output = sol->halvesAreAlike(example);
    cout << output;
    cout << " == true" << endl;

    example = "textbook";
    output = sol->halvesAreAlike(example);
    cout << output;
    cout << " == false" << endl;

    return 0;
}
