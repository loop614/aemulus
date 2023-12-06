/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 */

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum2 = function (nums, target) {
    for (let i = 0; i < nums.length; i++) {
        for (let j = i + 1; j < nums.length; j++) {
            if (nums[i] + nums[j] === target) {
                return [i, j];
            }
        }
    }
};

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function (nums, target) {
    let beforeDiff = {};
    for (let i  = 0; i < nums.length; i++) {
        if (typeof beforeDiff[target - nums[i]] !== 'undefined') {
            return [beforeDiff[target - nums[i]], i];
        }
        beforeDiff[nums[i]] = i;
    }
};


let iterations = {
    "nums": [[2, 7, 11, 15], [3, 2, 4], [3, 3], [2, 7, 11, 15]],
    "target": [9, 6, 6, 26],
    "output": [[0, 1], [1, 2], [0, 1], [2, 3]],
}

let errored = false;
for (let iter = 0; iter < iterations["nums"].length; iter++) {
    errored = false;
    let res = twoSum(iterations["nums"][iter], iterations["target"][iter]);
    for (let a = 0; a < iterations["output"][iter].length; a++) {
        if (iterations["output"][iter][a] !== res[a]) {
            errored = true;
            break;
        }
    }
    if (errored) {
        console.log(`Error ${iter} : ${iterations["nums"][iter]}, ${iterations["target"][iter]}, ${res}`);
        continue;
    }
    console.log(`Success ${iter} : ${iterations["nums"][iter]}, ${iterations["target"][iter]}, ${res}`);
}
