<?php declare(strict_types=1);

// 1. Two Sum
// Easy
// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order.

class Solution {

/**
 * @param Integer[] $nums
 * @param Integer $target
 *
 * @return Integer[]
 */
function twoSum($nums, $target): array {
    $table = [];

    for($i = 0; $i < count($nums); ++$i) {
        if (isset($table[$target - $nums[$i]])) return [$i, $table[$target - $nums[$i]]];
        $table[$nums[$i]] = $i;

    }

    return [];
}
}
