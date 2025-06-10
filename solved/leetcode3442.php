<?php declare(strict_types=1);
/*
3442. The Two Sneaky Numbers of Digitville
Easy
You are given a string s consisting of lowercase English letters.
Your task is to find the maximum difference diff = freq(a1) - freq(a2) between the frequency of characters a1 and a2 in the string such that:
    a1 has an odd frequency in the string.
    a2 has an even frequency in the string.
Return this maximum difference.
*/
class Solution {
    /**
     * @param String $s
     * @return Integer
     */
    function maxDifference($s) {
        $counts = [];
        for($i = 0; $i < strlen($s); $i++) {
            $counts[$s[$i]] ??= 0;
            $counts[$s[$i]]++;
        }

        $maxOdd = 0;
        $minEven = 100;
        foreach($counts as $count) {
            if (($count & 1) === 0) {
                if ($minEven > $count) {
                    $minEven = $count;
                }
            }
            else {
                if ($maxOdd < $count) {
                    $maxOdd = $count;
                }
            }
        }

        return $maxOdd - $minEven;
    }
}

$inputs = [
    "aaaaabbc",
    "abcabcab"
];

$outputs = [
    3,
    1
];

$sol = new Solution();
foreach ($inputs as $i => $input) {
    $out = $sol->maxDifference($input);
    if ($out === $outputs[$i]) {
        echo $i;
        echo ' ok ';
        echo PHP_EOL;
    } else {
        echo $i;
        echo ' not ok ';
        var_dump($out);
    }
}
