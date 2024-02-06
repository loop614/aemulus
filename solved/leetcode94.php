<!--
94. Binary Tree Inorder Traversal
Easy
Given the root of a binary tree, return the inorder traversal of its nodes' values.
-->

<?php
class TreeNode {
    public $val = null;
    public $left = null;
    public $right = null;
    function __construct($val = 0, $left = null, $right = null) {
        $this->val = $val;
        $this->left = $left;
        $this->right = $right;
    }
}

class Solution {
    /**
     * @param TreeNode $root, Integer[] &$ar
     */
    function trivialSolution(TreeNode $root, array &$arr): void {
        if ($root->left !== null) {
            $this->trivialSolution($root->left, $arr);
        }
        $arr[] = $root->val;
        if ($root->right !== null) {
            $this->trivialSolution($root->right, $arr);
        }
    }

    /**
     * @param TreeNode|null $root
     * @return Integer[]
     *
     * beats 86% by execution time
     * beats 96% by memory usage
     */
    function inorderTraversal(?TreeNode $root): array {
        if ($root === null) {
            return [];
        }
        $arr = [];
        $this->trivialSolution($root, $arr);

        return $arr;
    }
}

$sol = new Solution();
$expected0 = [];
$examplestr0 = $sol->inorderTraversal(null);
echo join(", ", $expected0);
echo "<-->";
echo join(", ", $examplestr0);
echo "\n";
echo $examplestr0 === $expected0 ? 'true': 'false';
echo "\n";

$example = new TreeNode(
    1,
    null,
    new TreeNode(2, new TreeNode(3), null)
);

$expected = [1,3,2];
$examplestr = $sol->inorderTraversal($example);
echo join(", ", $expected);
echo "<-->";
echo join(", ", $examplestr);
echo "\n";
echo $examplestr === $expected ? 'true': 'false';
echo "\n";


$example3 = new TreeNode(1);
$expected3 = [1];
$examplestr3 = $sol->inorderTraversal($example3);
echo join($expected3);
echo "<-->";
echo join($examplestr3);
echo "\n";
echo $examplestr3 === $expected3 ? 'true': 'false';
echo "\n";


$example4 = new TreeNode(
    25,
    new TreeNode(
        15,
        new TreeNode(
            10,
            new TreeNode(4),
            new TreeNode(12)
        ),
        new TreeNode(
            22,
            new TreeNode(18),
            new TreeNode(24)
        ),
    ),
    new TreeNode(
        50,
        new TreeNode(
            35,
            new TreeNode(31),
            new TreeNode(44)
        ),
        new TreeNode(
            70,
            new TreeNode(66),
            new TreeNode(90)
        ),
    ),
);

$expected4 = [4, 10, 12, 15, 18, 22, 24, 25, 31, 35, 44, 50, 66, 70, 90];
$examplestr4 = $sol->inorderTraversal($example4);
echo join(", ", $expected4);
echo "<-->";
echo join(", ", $examplestr4);
echo "\n";
echo $examplestr4 === $expected4 ? 'true': 'false';
echo "\n";
