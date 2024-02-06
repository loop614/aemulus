<?php declare(strict_types=1);

/**
 * 5. Longest Palindromic Substring
 * Medium
 * Given a string s, return the longest palindromic substring in s.
 */
class Solution {

    /**
     * @param string $s
     * @return string
     *
     * beats 50% by execution time
     * beats 97% by memory usage
     */
    function longestPalindrome(string $s) {
        $longest = "";
        for ($i = 0; $i < strlen($s); $i++) {
            $current = $s[$i];
            $leftPivot = $i - 1;
            $rightPivot = $i + 1;

            while (isset($s[$rightPivot]) && $s[$rightPivot] === $s[$i]) {
                $current .= $s[$rightPivot];
                $rightPivot++;
            }

            while (isset($s[$leftPivot]) && $leftPivot >= 0 && $s[$leftPivot] === $s[$i]) {
                $current .= $s[$leftPivot];
                $leftPivot--;
            }
            while (isset($s[$leftPivot]) && isset($s[$rightPivot]) && $leftPivot >= 0 && $s[$leftPivot] === $s[$rightPivot]) {
                $current = $s[$leftPivot] . $current . $s[$rightPivot];
                $leftPivot--;
                $rightPivot++;
            }
            if (strlen($current) > strlen($longest)) {
                $longest = $current;
            }
        }

        return $longest;
    }
}

$iterations = [
    "input" => ["aba", "babad", "cbbd", "a"],
    "output" => [["aba"], ["aba", "bab"], ["bb"], ["a"]],
];

$sol = new Solution();

foreach ($iterations["input"] as $index => $iteration) {
    $res = $sol->longestPalindrome($iteration);
    if (!in_array($res, $iterations["output"][$index])) {
        echo "Error: " . $iterations["input"][$index] . "\n\n";
        continue;
    }

    echo "Success: " . $iterations["input"][$index] . "\n\n";
}
