/*
404. Sum of Left Leaves
Easy
Given the root of a binary tree, return the sum of all left leaves.
A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.
*/
public class Leetcode404 {
    public static void main(String... args) {
        Solution404 sol = new Solution404();
        TreeNode404 example = new TreeNode404(1);
        System.out.println(sol.sumOfLeftLeaves(example) == 0);

        example = new TreeNode404(3);
        example.left = new TreeNode404(9);
        example.right = new TreeNode404(20);
        example.right.left = new TreeNode404(15);
        example.right.right = new TreeNode404(7);
        System.out.println(sol.sumOfLeftLeaves(example) == 24);

        example = new TreeNode404(0);
        example.left = new TreeNode404(1);
        example.right = new TreeNode404(2);
        example.right.left = new TreeNode404(1);
        example.right.right = new TreeNode404(2);
        example.right.right.left = new TreeNode404(1);
        example.right.right.right = new TreeNode404(2);
        example.right.right.right.left = new TreeNode404(1);
        example.right.right.right.right = new TreeNode404(2);
        System.out.println(sol.sumOfLeftLeaves(example) == 4);
    }
}

class TreeNode404 {
    int val;
    TreeNode404 left;
    TreeNode404 right;
    TreeNode404() {}
    TreeNode404(int val) { this.val = val; }
    TreeNode404(int val, TreeNode404 left, TreeNode404 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class SumHolder {
    public int sum = 0;
}

class Solution404 {
    public int sumOfLeftLeaves(TreeNode404 root) {
        SumHolder sh = new SumHolder();
        spin2(root, sh, false);

        return sh.sum;
    }

    private void spin2(TreeNode404 root, SumHolder sh, boolean isLeft) {
        if (root == null) {
            return;
        }
        if (isLeft && root.left == null && root.right == null) {
            sh.sum += root.val;
        }
        if (root.left != null) {
            spin2(root.left, sh, true);
        }
        if (root.right != null) {
            spin2(root.right, sh, false);
        }
    }
}
