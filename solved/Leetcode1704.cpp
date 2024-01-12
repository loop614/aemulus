#include <iostream>

using namespace std;

class Solution {
public:
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
