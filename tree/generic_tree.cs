class TreeNode {
    public int val;
    public List<TreeNode> children;

    public TreeNode(int val, TreeNode child1 = null, TreeNode child2 = null) {
        this.val = val;
        this.children = new List<TreeNode>();
        if (child1 != null) {
            this.children.Add(child1);
        }
        if (child2 != null) {
            this.children.Add(child2);
        }
    }

    public bool IsLeaf() {
        return this.children.Count == 0;
    }
}

class Solution {
    private void LevelOrderSpin(int[] currs, int[] arr, int levelWidth) {
    }

    public int[] LevelOrderRecursive(TreeNode root) {
        return new int[]{};
    }

    public int[] LevelOrder(TreeNode root) {
        return new int[]{};
    }

    private void InOrderSpin(TreeNode root, int[] arr)  {
    }

    public int[] InOrderRecursive(TreeNode root) {
        return new int[]{};
    }

    public int[] InOrder(TreeNode root) {
        return new int[]{};
    }
    private void PreOrderSpin(TreeNode root, int[] arr)  {
    }

    public int[] PreOrderRecursive(TreeNode root) {
        return new int[]{};
    }

    public int[] PreOrder(TreeNode root) {
        return new int[]{};
    }

    private void PostOrderSpin(TreeNode root, int[] arr)  {
    }

    public int[] PostOrderRecursive(TreeNode root) {
        return new int[]{};
    }

    public int[] PostOrder(TreeNode root) {
        return new int[]{};
    }
}


TreeNode example = new TreeNode(
    10,
    new TreeNode(
        12,
        new TreeNode(3),
        new TreeNode(
            4,
            new TreeNode(6),
            new TreeNode(7)
        )
    ),
    new TreeNode(
        5,
        new TreeNode(11),
        new TreeNode(
            2,
            null,
            new TreeNode(8)
        )
    )
);

Solution sol = new Solution();
int[] levelOrderExpected = new int[]{10, 12, 5, 3, 4, 11, 2, 6, 7, 8};
int[] inOrderExpected = new int[]{3, 12, 6, 4, 7, 10, 11, 5, 2, 8};
int[] preOrderExpected = new int[]{10, 12, 3, 4, 6, 7, 5, 11, 2, 8};
int[] postOrderExpected = new int[]{3, 6, 7, 4, 12, 11, 8, 2, 5, 10};

int[][] expectedArr = new int[][] {levelOrderExpected, inOrderExpected, preOrderExpected, postOrderExpected};

int[] levelOrderSolRecursive = sol.LevelOrderRecursive(example);
int[] inOrderSolRecursive = sol.InOrderRecursive(example);
int[] preOrderSolRecursive = sol.PreOrderRecursive(example);
int[] postOrderSolRecursive = sol.PostOrderRecursive(example);

int[] levelOrderSol = sol.LevelOrder(example);
int[] inOrderSol = sol.InOrder(example);
int[] preOrderSol = sol.PreOrder(example);
int[] postOrderSol = sol.PostOrder(example);

Dictionary<string, int[][]> solArray = new Dictionary<string, int[][]>()
{
    {"recursive", new int[][] {levelOrderSolRecursive, inOrderSolRecursive, preOrderSolRecursive, postOrderSolRecursive}},
    {"linear", new int[][] {levelOrderSol, inOrderSol, preOrderSol, postOrderSol}},
};

string[] names = new string[] {"levelOrder", "inOrder", "preOrder", "postOrder"};
for (int i = 0; i < expectedArr.Length; i++) {
    Console.Write(names[i]);
    Console.Write("\n");
    Console.Write(string.Join(", ", expectedArr[i]));
    Console.Write("<-.");
    Console.Write(string.Join(", ", solArray["recursive"][i]));
    Console.Write("\n");
    Console.Write(expectedArr[i] == solArray["recursive"][i] ? "true": "false");
    Console.Write("\n");
    Console.Write(string.Join(", ", expectedArr[i]));
    Console.Write("<-.");
    Console.Write(string.Join(", ", solArray["linear"][i]));
    Console.Write("\n");
    Console.Write(expectedArr[i] == solArray["linear"][i] ? "true": "false");
    Console.Write("\n");
    Console.Write("-----------------------");
    Console.Write("\n");
}
