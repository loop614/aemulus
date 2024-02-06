/*
209. Minimum Size Subarray Sum
Medium
Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray
whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
*/
/**
 * @param {number} target
 * @param {number[]} nums
 * @return {number}
 */
let minSubArrayLenWalking = function (target, nums) {
    let leftPivot = 0;
    let walkingSum = 0;
    let walkingSumParticipants = 0;
    let min = Infinity;

    // [5, 1, 3, 5, 10, 7, 4, 9, 2, 8],

    for (let i = 0; i < nums.length; i++) {
        walkingSum += nums[i];
        walkingSumParticipants++;

        while (walkingSum >= target) {
            if (walkingSumParticipants < min) {
                min = walkingSumParticipants;
            }
            walkingSum -= nums[leftPivot];
            walkingSumParticipants--;
            leftPivot++;
        }
    }

    return min !== Infinity ? min : 0;
};

/**
 * @param {number} target
 * @param {number[]} nums
 * @return {number}
 *
 * beats 34% by execution time
 * beats 99% by memory usage
 */
let minSubArrayLenDoubleFor = function (target, nums) {
    let curSum = 0;
    let curSumLen = 0;
    let minSumLen = Infinity;

    for (let i = 0; i < nums.length; i++) {
        curSumLen = 0;
        curSum = 0;
        for (let j = i; j < nums.length; j++) {
            curSum += nums[j];
            curSumLen++;
            if (curSum >= target) {
                if (curSumLen < minSumLen) {
                    minSumLen = curSumLen;
                }
                if (curSumLen === 1) {
                    return 1;
                }

                break;
            }
        }
        if (i === 0 && minSumLen === Infinity) {
            return 0;
        }
    }

    return minSumLen !== Infinity ? minSumLen : 0;
};


let iterations = {
    "functions": [minSubArrayLenDoubleFor, minSubArrayLenWalking],
    "nums": [
        [2, 3, 1, 2, 4, 3],
        [1, 1, 1, 1, 1, 1, 1, 1],
        [1, 4, 4],
        [10, 4, 4],
        [5, 1, 3, 5, 10, 7, 4, 9, 2, 8],
    ],
    "target": [7, 11, 4, 4, 15],
    "expectedMin": [2, 0, 1, 1, 2],
}


for (let functionIndex in iterations["functions"]) {
    for (let one in iterations["nums"]) {
        let target = iterations["target"][one];
        let nums = iterations["nums"][one];
        let expectedMin = iterations["expectedMin"][one];
        let funcName = iterations["functions"][functionIndex].name;
        let res = iterations["functions"][functionIndex](target, nums);
        if (res === expectedMin) {
            console.log(`${res} === ${expectedMin} success ${funcName} ${target} in ${nums}`);
        } else {
            console.error(`${res} !== ${expectedMin} error ${funcName} ${target} in ${nums}`);
        }
    }
}
