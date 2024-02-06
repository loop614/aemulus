<!--
13. Roman to Integer
Easy

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
-->

<?php

class Solution {
    /**
    * @param String $s
    * @return Integer
    *
    * beats 80% by execution time
    * beats 77% by memory usage
    *
    */
    function romanToInt(string $s) {
        $order = ['M', 'D', 'C', 'L', 'X', 'V', 'I'];
        $values = [
            'M' => 1000,
            'D' => 500,
            'C' => 100,
            'L' => 50,
            'X' => 10,
            'V' => 5,
            'I' => 1,
        ];
        $number = 0;
        $pivot = 0;
        $sstrlen = strlen($s);

        for ($i = 0; $i < 7; $i++) {
            while ($pivot < $sstrlen && $s[$pivot] === $order[$i]) {
                $number += $values[$order[$i]];
                $pivot++;
            }
            if (
                $pivot + 1 < $sstrlen &&
                $s[$pivot + 1] === $order[$i]
            ) {
                $number += $values[$s[$pivot+1]] - $values[$s[$pivot]];
                $pivot+=2;
            }
        }
        return $number;
    }
}

$s = ["MCMXCIV", "III", "LVIII", "CMXCIV"];
$output = [1994, 3, 58, 994];
$sol = new Solution();

for($i = 0; $i < count($s); $i++) {
    $res = $sol->romanToInt($s[$i]);
    echo $output[$i];
    echo "<-->";
    echo $res;
    echo "\n";
}
echo "\n";
