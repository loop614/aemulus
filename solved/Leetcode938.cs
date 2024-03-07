/*
938. Range Sum of BST
Easy
Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive range [low, high].
*/
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    private void CountVals(TreeNode root, int low, int high, ref int count) {
        if (root.val >= low && root.val <= high) {
            count +=root.val;
        }
        if (root.left != null && root.val > low) {
            CountVals(root.left, low, high, ref count);
        }
        if (root.right != null && root.val < high) {
            CountVals(root.right, low, high, ref count);
        }
    }


    public int RangeSumBST2(TreeNode root, int low, int high) {
        int count = 0;
        CountVals(root, low, high, ref count);

        return count;
    }

    public int RangeSumBST(TreeNode root, int low, int high) {
        int count = 0;
        Stack<TreeNode> sta = new();
        while (root != null) {
            while (root != null) {
                if (root.val >= low && root.val <= high) {
                    count+=root.val;
                }
                if (root.right != null) {
                    sta.Push(root);
                }
                root = root.left;
            }
            if (sta.Count == 0) {
                break;
            }

            root = sta.Pop();
            root = root?.right;
        }
        return count;
    }
}

var sol = new Solution();
TreeNode example1 =
    new(10,
        left: new TreeNode(
            5,
            left: new TreeNode(3, null, null),
            right: new TreeNode(7, null, null)
        ),
        right: new TreeNode(
            15,
            left: null,
            right: new TreeNode(18, null, null)
        )
    );


int output = sol.RangeSumBST(example1, 7, 15);
Console.WriteLine(output);
Console.WriteLine(output == 32);


TreeNode example2 = new(
    10,
    left: new TreeNode(
        5,
        left: new TreeNode(
            3,
            left: new TreeNode(1, null, null),
            right: null
        ),
        right: new TreeNode(
            7,
            left: new TreeNode(6, null, null),
            right: null
        )
    ),
    right: new TreeNode(
        15,
        left: new TreeNode(13, null, null),
        right: new TreeNode(18, null, null)
    )
);

output = sol.RangeSumBST2(example2, 6, 10);
Console.WriteLine(output);
Console.WriteLine(output == 23);
