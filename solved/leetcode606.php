<?php

// 606. Construct String from Binary Tree
// Medium
// Given the root node of a binary tree, your task is to create a string representation of the tree following a specific set of formatting rules. The representation should be based on a preorder traversal of the binary tree and must adhere to the following guidelines:
//     Node Representation: Each node in the tree should be represented by its integer value.
//     Parentheses for Children: If a node has at least one child (either left or right), its children should be represented inside parentheses. Specifically:
//         If a node has a left child, the value of the left child should be enclosed in parentheses immediately following the node's value.
//         If a node has a right child, the value of the right child should also be enclosed in parentheses. The parentheses for the right child should follow those of the left child.
//     Omitting Empty Parentheses: Any empty parentheses pairs (i.e., ()) should be omitted from the final string representation of the tree, with one specific exception: when a node has a right child but no left child. In such cases, you must include an empty pair of parentheses to indicate the absence of the left child. This ensures that the one-to-one mapping between the string representation and the original binary tree structure is maintained.
//     In summary, empty parentheses pairs should be omitted when a node has only a left child or no children. However, when a node has a right child but no left child, an empty pair of parentheses must precede the representation of the right child to reflect the tree's structure accurately.

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
