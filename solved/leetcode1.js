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
