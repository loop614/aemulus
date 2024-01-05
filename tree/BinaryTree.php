<?php

class TreeNode {
    public int $val;
    public ?TreeNode $left = null;
    public ?TreeNode $right = null;

    function __construct(int $val, ?TreeNode $left = null, ?TreeNode $right = null) {
        $this->val = $val;
        $this->left = $left;
        $this->right = $right;
    }
}

class Solution {
    /**
     * @param TreeNode $root, &$root array
     *
     * @return void
     */
    function levelOrderSpin(array &$currs, array &$arr, int $levelWidth): void {
        $newLevelWidth = 0;
        $breakOut = true;

        foreach($currs as $curr) {
            if ($curr->left !== null) {
                $currs[] = $curr->left;
                $newLevelWidth++;
                $breakOut = false;
            }
            if ($curr->right !== null) {
                $currs[] = $curr->right;
                $newLevelWidth++;
                $breakOut = false;
            }
        }

        while($levelWidth--) {
            $pivot = array_shift($currs);
            $arr[] = $pivot->val;
        }

        if ($breakOut) {
            return;
        }

        $this->levelOrderSpin($currs, $arr, $newLevelWidth);
    }

    /**
     * @param TreeNode $root
     *
     * @return Integer[]
     */
    function levelOrderRecursive(TreeNode $root): array {
        $arr = [];
        $currs = [$root];
        $this->levelOrderSpin($currs, $arr, 1);

        return $arr;
    }

    /**
     * @param TreeNode $root
     *
     * @return Integer[]
     */
    function levelOrder(TreeNode $root) {
        $arr = [];
        $runLoop = true;
        $current = [$root];

        while ($runLoop) {
            $runLoop = false;
            $levelWidth = 0;
            foreach($current as $curr) {
                if ($curr->left !== null) {
                    $current[] = $curr->left;
                    $levelWidth++;
                    $runLoop = true;
                }
                if ($curr->right !== null) {
                    $current[] = $curr->right;
                    $levelWidth++;
                    $runLoop = true;
                }
            }

            $count = count($current) - $levelWidth;
            while($count--) {
                $pivot = array_shift($current);
                $arr[] = $pivot->val;
            }
        }

        return $arr;
    }

    /**
     * @param TreeNode $root, &$root array
     *
     * @return void
     */
    function inOrderSpin(TreeNode $root, array &$arr): void {
        if ($root->left !== null) {
            $this->inOrderSpin($root->left, $arr);
        }
        $arr[] = $root->val;
        if ($root->right !== null) {
            $this->inOrderSpin($root->right, $arr);
        }
    }

    /**
     * @param TreeNode $root
     *
     * @return Integer[]
     */
    function inOrderRecursive(TreeNode $root) {
        $arr = [];
        $this->inOrderSpin($root, $arr);

        return $arr;
    }


    /**
     * @param TreeNode $root
     *
     * @return Integer[]
     */
    function inOrder(TreeNode $root) {
        $arr = [];
        return $arr;
    }

    /**
     * @param TreeNode $root, &$root array
     *
     * @return void
     */
    function preOrderSpin(TreeNode $root, array &$arr): void {
        $arr[] = $root->val;
        if ($root->left !== null) {
            $this->preOrderSpin($root->left, $arr);
        }
        if ($root->right !== null) {
            $this->preOrderSpin($root->right, $arr);
        }
    }

    /**
     * @param TreeNode $root
     *
     * @return Integer[]
     */
    function preOrderRecursive(TreeNode $root) {
        $arr = [];
        $this->preOrderSpin($root, $arr);

        return $arr;
    }

    /**
     * @param TreeNode $root
     *
     * @return Integer[]
     */
    function preOrder(TreeNode $root) {
        $arr = [];
        $runLoop = true;
        $count = 0;
        $stack = [];
        $curr = $root;
        while ($curr !== null || count($stack) !== 0) {
            while ($curr !== null) {
                $arr[] = $curr->val;
                if ($curr->right !== null) {
                    $stack[] = $curr;
                }
                $curr = $curr->left;
            }

            $curr = array_pop($stack);
            $curr = $curr?->right;
        }

        return $arr;
    }

    /**
     * @param TreeNode $root, &$root array
     *
     * @return void
     */
    function postOrderSpin(TreeNode $root, array &$arr): void {
        if ($root->left !== null) {
            $this->postOrderSpin($root->left, $arr);
        }
        if ($root->right !== null) {
            $this->postOrderSpin($root->right, $arr);
        }
        $arr[] = $root->val;
    }

    /**
     * @param TreeNode $root
     *
     * @return Integer[]
     */
    function postOrderRecursive(TreeNode $root) {
        $arr = [];
        $this->postOrderSpin($root, $arr);

        return $arr;
    }

    /**
     * @param TreeNode $root
     *
     * @return Integer[]
     */
    function postOrder(TreeNode $root) {
        $arr = [];
        return $arr;
    }
}

$sol = new Solution();

$example = new TreeNode(
    10,
    new TreeNode(
        12,
        new TreeNode(3),
        new TreeNode(
            4,
            new TreeNode(6),
            new TreeNode(7)
        ),
    ),
    new TreeNode(
        5,
        new TreeNode(11),
        new TreeNode(
            2,
            null,
            new TreeNode(8)
        ),
    ),
);

$levelOrderExpected = [10, 12, 5, 3, 4, 11, 2, 6, 7, 8];
$inOrderExpected = [3, 12, 6, 4, 7, 10, 11, 5, 2, 8];
$preOrderExpected = [10, 12, 3, 4, 6, 7, 5, 11, 2, 8];
$postOrderExpected = [3, 6, 7, 4, 12, 11, 8, 2, 5, 10];

$expectedArr = [$levelOrderExpected, $inOrderExpected, $preOrderExpected, $postOrderExpected];

$levelOrderSolRecursive = $sol->levelOrderRecursive($example);
$inOrderSolRecursive = $sol->inOrderRecursive($example);
$preOrderSolRecursive = $sol->preOrderRecursive($example);
$postOrderSolRecursive = $sol->postOrderRecursive($example);

$levelOrderSol = $sol->levelOrder($example);
$inOrderSol = $sol->inOrder($example);
$preOrderSol = $sol->preOrder($example);
$postOrderSol = $sol->postOrder($example);

$solArray = [
    "recursive" => [$levelOrderSolRecursive, $inOrderSolRecursive, $preOrderSolRecursive, $postOrderSolRecursive],
    "linear" => [$levelOrderSol, $inOrderSol, $preOrderSol, $postOrderSol],
    "names" => ["levelOrder", "inOrder", "preOrder", "postOrder"],
];

for ($i = 0; $i < count($expectedArr); $i++) {
    echo $solArray["names"][$i];
    echo "\n";
    echo join(", ", $expectedArr[$i]);
    echo "<-->";
    echo join(", ", $solArray["recursive"][$i]);
    echo "\n";
    echo $expectedArr[$i] === $solArray["recursive"][$i] ? 'true': 'false';
    echo "\n";
    echo join(", ", $expectedArr[$i]);
    echo "<-->";
    echo join(", ", $solArray["linear"][$i]);
    echo "\n";
    echo $expectedArr[$i] === $solArray["linear"][$i] ? 'true': 'false';
    echo "\n";
    echo "-----------------------";
    echo "\n";
}
