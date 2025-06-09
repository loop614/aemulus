<?php
/*
2161. Partition Array According to Given Pivot
Medium
You are given a 0-indexed integer array nums and an integer pivot. Rearrange nums such that the following conditions are satisfied:
    Every element less than pivot appears before every element greater than pivot.
    Every element equal to pivot appears in between the elements less than and greater than pivot.
    The relative order of the elements less than pivot and the elements greater than pivot is maintained.
        More formally, consider every pi, pj where pi is the new position of the ith element and pj is the new position of the jth element. If i < j and both elements are smaller (or larger) than pivot, then pi < pj.
Return nums after the rearrangement.
*/
class Solution2161 {

    /**
     * @param Integer[] $nums
     * @param Integer $pivot
     * @return Integer[]
     */
    function pivotArray($nums, $pivot) {
        $before = [];
        $countSame = 0;
        $after = [];
        foreach ($nums as $num) {
            if ($num < $pivot) {
                $before[] = $num;
            }
            else if ($num > $pivot) {
                $after[] = $num;
            }
            else {
                $countSame++;
            }
        }

        while ($countSame-- > 0) {
            $before[] = $pivot;
        }

        foreach($after as $afterOne) {
            $before[] = $afterOne;
        }


        return $before;
    }
}

$sol = new Solution2161();
$inputs = [
    [9,12,5,10,14,3,10],
    [-3,4,3,2],
    [1,8,3,4,6,7,2,9]
];
$pivots = [10, 2, 5];
$ress = [
    [9,5,3,10,10,12,14],
    [-3,2,4,3],
    [1,3,4,2,8,6,7,9]
];

foreach ($inputs as $i => $input) {
    $pivot = $pivots[$i];
    $out = $sol->pivotArray($input, $pivot);
    $expected = $ress[$i];
    if ($out === $expected) {
        echo $i . ' passed';
    } else {
        echo $i . ' failed';
        echo PHP_EOL;
        echo join(',', $expected);
        echo PHP_EOL;
        echo join(',', $out);
    }
    echo PHP_EOL;
}
