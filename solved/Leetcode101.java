/*
101. Symmetric Tree
Easy
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 */

import java.util.Stack;

public class Leetcode101 {

    public static void main(String[] args) {
        Solution101 sol = new Solution101();
        TreeNode example;

        example = new TreeNode(2);
        example.left = new TreeNode(3);
        example.left.left = new TreeNode(4);
        example.left.right = new TreeNode(5);
        example.right = new TreeNode(3);
        example.right.left = null;
        example.right.right = new TreeNode(4);
        System.out.println(sol.isSymmetric(example) == false);

        example = new TreeNode(1);
        example.left = new TreeNode(2);
        example.left.right = new TreeNode(3);
        example.left.right.left = new TreeNode(4);
        example.right = new TreeNode(2);
        example.right.left = new TreeNode(3);
        example.right.left.right = new TreeNode(4);
        System.out.println(sol.isSymmetric(example) == true);

        example = new TreeNode(1);
        example.left = new TreeNode(2);
        example.left.left = new TreeNode(3);
        example.left.right = new TreeNode(4);
        example.right = new TreeNode(2);
        example.right.left = new TreeNode(4);
        example.right.right = new TreeNode(3);
        System.out.println(sol.isSymmetric(example) == true);

        example = new TreeNode(1);
        example.left = new TreeNode(2);
        example.left.right = new TreeNode(3);
        example.right = new TreeNode(2);
        example.right.right = new TreeNode(3);
        System.out.println(sol.isSymmetric(example) == false);

        example = new TreeNode(1);
        System.out.println(sol.isSymmetric(example) == true);

        example = new TreeNode(1);
        example.left = new TreeNode(2);
        System.out.println(sol.isSymmetric(example) == false);
    }
}

/**
 * Definition for a binary tree node.
 */
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution101 {

    public boolean isSymmetric(TreeNode root) {
        if (root.left != null && root.right != null && root.left.val == root.right.val) {
            return isSymmetricRec(root.left, root.right, new Stack<>(), new Stack<>());
        }
        else if (root.left == null && root.right == null) {
            return true;
        }
        return false;
    }

    public boolean isSymmetricRec(TreeNode rootl, TreeNode rootr, Stack<TreeNode> leftBranch, Stack<TreeNode> rightBranch) {
        TreeNode leftCur = rootl;
        TreeNode rightCur = rootr;

        while (true) {
            if (leftCur != null && rightCur != null && leftCur.val == rightCur.val) {
                leftBranch.push(leftCur);
                rightBranch.push(rightCur);
            }
            else if (leftCur == null && rightCur == null) {
                break;
            }
            else {
                return false;
            }
            leftCur = leftCur.left;
            rightCur = rightCur.right;
        }

        while (!leftBranch.isEmpty()) {
            leftCur = leftBranch.pop();
            rightCur = rightBranch.pop();
            if (leftCur.val == rightCur.val) {
                if (leftCur.right != null && rightCur.left != null) {
                    return isSymmetricRec(leftCur.right, rightCur.left, leftBranch, rightBranch);
                }
                else if (leftCur.right != null || rightCur.left != null) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }
}
