<?php

class Solution {
    // best php sol
    public function isAnagram(String $s, String $t): bool {
        if (strlen($s) != strlen($t)) {
            return false;
        }
        $len = strlen($s);

        $sa = [];
        $sa = array_fill(0, 26, 0);

        for($i = 0; $i < $len; $i++) {
            $sa[ord($s[$i])-97]++;
            $sa[ord($t[$i])-97]--;
        }

        for($i = 0; $i < 26; $i++) {
            if ($sa[$i] !== 0) {
                return false;
            }
        }

        return true;
    }

    // best java sol
    public function isAnagram2(String $s, String $t): bool {
        if (strlen($s) != strlen($t)) {
            return false;
        }
        $sc = str_split($s);
        $tc = str_split($t);
        sort($sc);
        sort($tc);

        return $sc == $tc;
    }

    public function isAnagram3(String $s, String $t): bool {
        if (strlen($s) != strlen($t)) {
            return false;
        }
        $tl = $sl = strlen($s);

        for ($i=0; $i < $sl; $i++) {
            $h = false;
            for ($j=0; $j < $tl; $j++) {
                if ($s[$i] == $t[$j]) {
                    $h = true;
                    break;
                }
            }
            if ($h) {
                $t = preg_replace("/$t[$j]/", "", $t, 1);
                $tl--;
            }
        }

        return strlen($t) == 0;
    }
}
$sol = new Solution();

$output = $sol->isAnagram("anagram", "nagaram");
echo $output == true ? 'true' : 'false';

$output = $sol->isAnagram2("rat", "car");
echo $output == false ? 'true' : 'false';

$output = $sol->isAnagram3("ba", "ab");
echo $output == true ? 'true' : 'false';
