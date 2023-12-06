<?php

class Solution {
    /**
    * @param String $s
    * @return Integer
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
