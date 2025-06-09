<?php
/*
3024. Type of Triangle
Easy
You are given a 0-indexed integer array nums of size 3 which can form the sides of a triangle.
    A triangle is called equilateral if it has all sides of equal length.
    A triangle is called isosceles if it has exactly two sides of equal length.
    A triangle is called scalene if all its sides are of different lengths.
Return a string representing the type of triangle that can be formed or "none" if it cannot form a triangle.
*/
class Solution {

    /**
     * @param Integer[] $nums
     * @return String
     */
    function triangleType(array $nums): string {
        $a = $nums[0];
        $b = $nums[1];
        $c = $nums[2];

        if ((-$a + $b + $c)*($a -$b + $c)*($a + $b - $c) > 0) {
            if ($a === $b && $b === $c) {
                return "equilateral";
            }

            if ($a !== $b && $b !== $c && $a !== $c) {
                return "scalene";
            }

            return "isosceles";

            /*if (
                ($a === $b && $b !== $c && $a !== $c) ||
                ($a === $c && $b !== $c && $a !== $b) ||
                ($b === $c && $b !== $c && $a !== $b)
            ) {
                return "isosceles";
            }*/
        }

        return "none";
    }
}

$sol = new Solution();

$inputs = [
    [3,3,3],
    [3,4,5]
];

$outputs = [
    "equilateral",
    "scalene"
];

foreach ($inputs as $i => $input) {
    $out = $sol->triangleType($input);
    if ($out === $outputs[$i]) {
        echo $i . ': sucess' . PHP_EOL;
        continue;
    }
    echo $i . ': failed' . PHP_EOL;
}
