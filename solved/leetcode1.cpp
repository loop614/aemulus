/*
1. Two Sum
Easy
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
*/

class Solution {
public:
    /*
     * beats 89% by execution time
     * beats 46% by memory usage
     */
    vector<int> twoSum(vector<int>& nums, int target) {
        std::unordered_map<int,int> table;
        for(int i=0;i<nums.size();i++){
            if (table.find(target-nums[i]) != table.end()) {
                return {table[target-nums[i]], i};
            }
            table[nums[i]] = i;
        }
        return {0, 0};
    }
};
