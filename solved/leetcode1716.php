<?php

class Solution {

    /**
     * @param Integer $n
     * @return Integer
     */
    function totalMoney($n) {
        $monday = 1;
        $total = 0;
        while ($n > 0) {
            for ($i = 0; $i < 7 && $n > 0; $i++) {
                $total += $monday + $i;
                $n--;
            }
            $monday++;
        }

        return $total;
    }
} 

echo (new Solution())->totalMoney(4);
echo (new Solution())->totalMoney(10);
echo (new Solution())->totalMoney(20);
