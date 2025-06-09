<?php declare(strict_types=1);
/*
2429. Minimize XOR
Medium
Given two positive integers num1 and num2, find the positive integer x such that:
    x has the same number of set bits as num2, and
    The value x XOR num1 is minimal.
Note that XOR is the bitwise XOR operation.
Return the integer x. The test cases are generated such that x is uniquely determined.
The number of set bits of an integer is the number of 1's in its binary representation.
*/
class Solution
{
    function minimizeXor($num1, $num2)
    {
        $setBits2 = count_chars(decbin($num2), 1)[49];
        $num1Bi = decbin($num1);
        $setBits1 = count_chars($num1Bi, 1)[49];
        $chars = str_split($num1Bi);
        $res = '';

        if ($setBits2 > $setBits1) {
            $res = $num1Bi;
            $setBits2 -= $setBits1;
            $res2 = '';
            for ($i = count($chars)-1; $i >= 0; $i--) {
                $let = $chars[$i];
                if ($setBits2-1 >= 0 && $let === '0') {
                    $let = '1';
                    $setBits2--;
                }
                $res2 .= $let;
            }
            while ($setBits2-- > 0) {
                $res2 .= '1';
            }

            return bindec(strrev($res2));

        } else if ($setBits2 < $setBits1) {
            for ($i = 0; $i < count($chars); $i++) {
                if ($chars[$i] === '1' && $setBits2 > 0) {
                    $res .= $chars[$i];
                    $setBits2--;
                    continue;
                }
                $res .= '0';
            }
            return bindec($res);

        }

        return $num1;
    }
}

$sol = new Solution();
var_dump($sol->minimizeXor(3, 5)); // 3
var_dump($sol->minimizeXor(1, 12)); // 3
var_dump($sol->minimizeXor(25, 72)); // 24
var_dump($sol->minimizeXor(65, 84)); // 67
// 10101001
//      111
