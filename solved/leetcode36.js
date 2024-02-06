/*
36. Valid Sudoku
Medium
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

    Each row must contain the digits 1-9 without repetition.
    Each column must contain the digits 1-9 without repetition.
    Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

Note:

    A Sudoku board (partially filled) could be valid but is not necessarily solvable.
    Only the filled cells need to be validated according to the mentioned rules.
*/

function sudoCmp(inputArray) {
    // ['1', '2', '3', '4', '5', '6', '7'];
    // ['2', '.', '6', '.', '.', '.', '4'];
    let inputArrayClean = inputArray.filter(function (e, i) {
        return inputArray[i] !== '.'
    })
    return inputArrayClean.length === (new Set(inputArrayClean)).size;
}

/**
 * @param {string[][]} board
 * @return {boolean}
 *
 * beats 58% by execution time
 * beats 38% by memory usage
 */
var isValidSudoku = function (board) {
    let tempArray = [];
    let result;
    for (let i = 0; i < 9; i++) {
        result = sudoCmp(board[i]);
        if (!result) {
            console.log("\tfailed on rows");
            return false;
        }
        for (let j = 0; j < 9; j++) {
            tempArray.push(board[j][i]);
            result = sudoCmp(tempArray);
            if (!result) {
                console.log("\tfailed on columns");
                return false;
            }
        }
        tempArray = [];
    }

    // [
    //     ["5", "3", ".", ".", "7", ".", ".", ".", "."],
    //     ["6", ".", ".", "1", "9", "5", ".", ".", "."],
    //     [".", "9", "8", ".", ".", ".", ".", "6", "."],
    //     ["8", ".", ".", ".", "6", ".", ".", ".", "3"],
    //     ["4", ".", ".", "8", ".", "3", ".", ".", "1"],
    //     ["7", ".", ".", ".", "2", ".", ".", ".", "6"],
    //     [".", "6", ".", ".", ".", ".", "2", "8", "."],
    //     [".", ".", ".", "4", "1", "9", ".", ".", "5"],
    //     [".", ".", ".", ".", "8", ".", ".", "7", "9"]
    // ]
    let x1;
    let y1;
    let pivot;
    for (let t = 0; t < 9; t++) {
        pivot = Math.floor(t / 3);
        x1 = (t - pivot * 3) * 3;
        y1 = pivot * 3;
        for (let i = x1; i < x1 + 3; i++) {
            for (let j = y1; j < y1 + 3; j++) {
                tempArray.push(board[i][j]);
            }
        }
        result = sudoCmp(tempArray);
        if (!result) {
            console.log("\tfailed on columns");
            return false;
        }
        tempArray = [];
    }

    return true;
};


// START:: ---------------------
let iterations = {
    "boards": [
        [
            ["5", "3", ".", ".", "7", ".", ".", ".", "."],
            ["6", ".", ".", "1", "9", "5", ".", ".", "."],
            [".", "9", "8", ".", ".", ".", ".", "6", "."],
            ["8", ".", ".", ".", "6", ".", ".", ".", "3"],
            ["4", ".", ".", "8", ".", "3", ".", ".", "1"],
            ["7", ".", ".", ".", "2", ".", ".", ".", "6"],
            [".", "6", ".", ".", ".", ".", "2", "8", "."],
            [".", ".", ".", "4", "1", "9", ".", ".", "5"],
            [".", ".", ".", ".", "8", ".", ".", "7", "9"]
        ],
        [
            ["8", "3", ".", ".", "7", ".", ".", ".", "."],
            ["6", ".", ".", "1", "9", "5", ".", ".", "."],
            [".", "9", "8", ".", ".", ".", ".", "6", "."],
            ["8", ".", ".", ".", "6", ".", ".", ".", "3"],
            ["4", ".", ".", "8", ".", "3", ".", ".", "1"],
            ["7", ".", ".", ".", "2", ".", ".", ".", "6"],
            [".", "6", ".", ".", ".", ".", "2", "8", "."],
            [".", ".", ".", "4", "1", "9", ".", ".", "5"],
            [".", ".", ".", ".", "8", ".", ".", "7", "9"]
        ],
        [
            [".", ".", ".", ".", "5", ".", ".", "1", "."],
            [".", "4", ".", "3", ".", ".", ".", ".", "."],
            [".", ".", ".", ".", ".", "3", ".", ".", "1"],
            ["8", ".", ".", ".", ".", ".", ".", "2", "."],
            [".", ".", "2", ".", "7", ".", ".", ".", "."],
            [".", "1", "5", ".", ".", ".", ".", ".", "."],
            [".", ".", ".", ".", ".", "2", ".", ".", "."],
            [".", "2", ".", "9", ".", ".", ".", ".", "."],
            [".", ".", "4", ".", ".", ".", ".", ".", "."]
        ]
    ],
    "outcomes": [true, false, false]
};

for (let i = 0; i < iterations["boards"].length; i++) {
    let res = isValidSudoku(iterations["boards"][i]);
    if (res === iterations["outcomes"][i]) {
        console.log(`Success: ${i} was ${res}, expected ${iterations["outcomes"][i]}`);
    } else {
        console.error(`Error: ${i} was ${res}, expected ${iterations["outcomes"][i]}`);
    }
}
