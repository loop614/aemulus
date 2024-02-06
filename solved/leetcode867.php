<?php

// 867. Transpose Matrix
// Easy
// Given a 2D integer array matrix, return the transpose of matrix.
// The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.

class Solution {
    /**
     * @param Integer[][] $matrix
     * @return Integer[][]
     *
     * beats 31% by execution time
     * beats 33% by memory usage
     */
    function transpose(array $matrix): array {
        $arr = [[]];
        for($i = 0; $i < count($matrix); $i++) {
            for($j = 0; $j < count($matrix[$i]); $j++) {
                $arr[$j][$i] = $matrix[$i][$j];
            }
        }

        return $arr;
    }
}

function printMatrix(array $matrix) {
    $n = count($matrix);
    for($i = 0; $i < $n; $i++) {
        for($j = 0; $j < $n; $j++) {
            if (isset($matrix[$i][$j])) {
                echo $matrix[$i][$j];
                continue;
            }
            echo "x";
        }
        echo "\n";
    }
}

$inputs = [
    [[1,2,3],[4,5,6],[7,8,9]],
    [[1,2,3],[4,5,6]],
    [[7,2]],
    [[5],[8]]
];

$expected = [
    [[1,4,7],[2,5,8],[3,6,9]],
    [[1,4],[2,5],[3,6]],
    [[7],[2]],
    [[5, 8]]
];

$sol = new Solution();

for($i = 0; $i < count($inputs); $i++) {
    echo "--------------------------\n";
    $output = $sol->transpose($inputs[$i]);
    echo "input:\n";
    printMatrix($inputs[$i]);
    echo "\n";
    echo "expected:\n";
    printMatrix($expected[$i]);
    echo "\n";
    echo "output:\n";
    printMatrix($output);
    var_dump($output);
    echo "\n";

    echo $output === $expected[$i] ? 'true' : 'false';
    echo "\n";
    echo "--------------------------\n";
}
