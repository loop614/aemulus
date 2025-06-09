#!/usr/bin/env php
<?php declare(strict_types=1);
/*
3289. The Two Sneaky Numbers of Digitville
Easy
In the town of Digitville, there was a list of numbers called nums containing integers from 0 to n - 1. Each number was supposed to appear exactly once in the list, however, two mischievous numbers sneaked in an additional time, making the list longer than usual.
As the town detective, your task is to find these two sneaky numbers. Return an array of size two containing the two numbers (in any order), so peace can return to Digitville.
*/
class Solution {
    /**
     * @param Integer[] $nums
     * @return Integer[]
     */
    function getSneakyNumbers($nums) {
        $hashMap = [];
        $firstres = null;
        foreach($nums as $num) {
            $hashMap[$num] ??= 0;
            $hashMap[$num]++;
            if ($hashMap[$num] === 2) {
                if ($firstres === null) {
                    $firstres = $num;
                } else if ($firstres !== $num) {
                    return [$firstres, $num];
                }
            }
        }

        return [$firstres, $num];
    }
}

$inputs = [
    [0,1,1,0],
    [0,3,2,1,3,2],
    [7,1,5,4,3,4,6,0,9,5,8,2]
];

$outputs = [
    [0,1],
    [2,3],
    [4,5]
];

$sol = new Solution();
foreach ($inputs as $i => $input) {
    $out = $sol->getSneakyNumbers($input);
    if (count(array_diff($out, $outputs[$i])) === 0) {
        echo $i;
        echo ' ok ';
        echo PHP_EOL;
    } else {
        echo $i;
        echo ' not ok ';
        var_dump($out);
        echo PHP_EOL;
    }
}
