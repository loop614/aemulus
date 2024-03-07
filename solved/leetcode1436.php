<?php

// 1436. Destination City
// Easy

// You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from cityAi to cityBi. Return the destination city, that is, the city without any path outgoing to another city.
// It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one destination city.

class Solution {
    /**
     * @param String[][] $paths
     * @return String
     */
    function destCity(array $paths): string {
        $left = [];
        $right = [];

        foreach($paths as $path) {
            $left[] = $path[0];
            $right[] = $path[1];
        }

        foreach($right as $r) {
            if (!in_array($r, $left)) {
                return $r;
            }
        }
        return "";
    }
}


$iterations = [
    "input" => [
        [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]],
        [["B","C"],["D","B"],["C","A"]],
        [["A","Z"]]
    ],
    "output" => [
        "Sao Paulo",
        "A",
        "Z"
    ]
];

$sol = new Solution();

foreach ($iterations["input"] as $index => $iteration) {
    $res = $sol->destCity($iteration);
    if ($res !== $iterations["output"][$index]) {
        echo "Error: $index \n";
        continue;
    }

    echo "Success: $index \n";
}
