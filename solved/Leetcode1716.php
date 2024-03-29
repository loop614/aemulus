<?php
/*
1716. Calculate Money in Leetcode Bank
Easy
Hercy wants to save money for his first car. He puts money in the Leetcode bank every day.
He starts by putting in $1 on Monday, the first day. Every day from Tuesday to Sunday, he will put in $1 more than the day before. On every subsequent Monday, he will put in $1 more than the previous Monday.
Given n, return the total amount of money he will have in the Leetcode bank at the end of the nth day.
*/
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
