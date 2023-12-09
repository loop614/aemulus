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
    function spinAround(TreeNode $root, array &$letters): void {
        $letters[] = $root->val;
        if ($root->left === null && $root->right === null) {
            $letters[] = ")";
            return;
        }

        if ($root->left !== null) {
            $letters[] = "(";
            $this->spinAround($root->left, $letters);
        } else {
            $letters[] = "(";
            $letters[] = ")";
        }

        if ($root->right !== null) {
            $letters[] = "(";
            $this->spinAround($root->right, $letters);
        }

        $letters[] = ")";
    }

    /**
     * @param TreeNode $root
     * @return String
     */
    function tree2str(TreeNode $root): String {
        $letters = [];
        $this->spinAround($root, $letters);
        array_pop($letters);

        return implode("", $letters);
    }
}

$sol = new Solution();

$example = new TreeNode(
    1,
    new TreeNode(2, new Treenode(4)),
    new TreeNode(3)
);

$expected = "1(2(4))(3)";
$examplestr = $sol->tree2str($example);
echo $expected;
echo "<-->";
echo $examplestr;
echo "\n";
echo $examplestr === $expected ? 'true': 'false';
echo "\n";


$example2 = new TreeNode(
    1,
    new TreeNode(2, null, new Treenode(4)),
    new TreeNode(3)
);

$expected2 = "1(2()(4))(3)";
$examplestr2 = $sol->tree2str($example2);
echo $expected2;
echo "<-->";
echo $examplestr2;
echo "\n";
echo $examplestr2 === $expected2 ? 'true': 'false';
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

$expected4 = "25(15(10(4)(12))(22(18)(24)))(50(35(31)(44))(70(66)(90)))";
$examplestr4 = $sol->tree2str($example4);
echo $expected4;
echo "<-->\n";
echo $examplestr4;
echo "\n";
echo $examplestr4 === $expected4 ? 'true': 'false';
echo "\n";
