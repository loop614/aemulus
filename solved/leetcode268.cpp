/*
268. Missing Number
Easy
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
*/
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    /*
     * beats 85% by execution time
     * beats 33% by memory usage
     */
    int missingNumber(vector<int>& nums) {
        int sum = 0;
        int max = 0;
        unsigned int i;
        for (i = 0; i < nums.size(); i++) {
            sum += nums[i];
            sum -= i;
            if (nums[i] > max ) { max = nums[i]; }
        }

        if (sum == 0) {
            return i;
        }

        return max-sum;
    }

    /*
     * beats 25% by execution time
     * beats 14% by memory usage
     */
    int missingNumberNaive(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        unsigned int i;
        for (i = 0; i < nums.size(); i++) {
            if ((unsigned int)nums[i] != i) {
                return i;
            }
        }

        return i;
    }
};

int main()
{
    Solution sol;
    vector<vector<int>> nums = {{10,9,6,4,2,3,5,7,0,1}, {0,1,2}, {3,0,1}};
    vector<int> res = {8, 3, 2};
    int output;
    for(unsigned int i = 0; i < nums.size(); i++) {
        output = sol.missingNumber(nums[i]);
        cout << output;
        cout << " ";
        cout << res[i];
        cout << endl;
    }
}
