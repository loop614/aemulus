/*
100. Same Tree
Easy
Given the roots of two binary trees p and q, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 */
public class Leetcode100 {
    public static void main(String[] args) {
        Solution100 sol = new Solution100();
        TreeNode example, example2;
        boolean output;
        example = new TreeNode(1);
        example.left = new TreeNode(3);
        example.right = new TreeNode(2);
        example2 = new TreeNode(1);
        example2.left = new TreeNode(2);
        example2.right = new TreeNode(3);
        output = sol.isSameTree(example, example2);
        System.out.println(output == false);
        example = new TreeNode(1);
        example.left = new TreeNode(2);
        example.right = new TreeNode(3);
        example2 = new TreeNode(1);
        example2.left = new TreeNode(2);
        example2.right = new TreeNode(3);
        output = sol.isSameTree(example, example2);
        System.out.println(output == true);
        example = new TreeNode(1);
        example.left = new TreeNode(2);
        example2 = new TreeNode(1);
        example2.right = new TreeNode(3);
        output = sol.isSameTree(example, example2);
        System.out.println(output == false);
    }
}

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

class Solution100 {
    public boolean isSameTreeSpin(TreeNode p, TreeNode q) {
        boolean res = true;
        if (p.left != null && q.left != null) {
            res &= isSameTreeSpin(p.left, q.left);
        } else if (!(p.left == null && q.left == null)) {
            return false;
        }
        if (!res) {return false;}
        if (p.right != null && q.right != null) {
            res &= isSameTreeSpin(p.right, q.right);
        } else if (!(p.right == null && q.right == null)) {
            return false;
        }
        if (!res) {return false;}

        if (p.val != q.val) {
            return false;
        }

        return res;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return  false;
        }

        return isSameTreeSpin(p, q);
    }
}
