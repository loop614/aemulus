#!/usr/bin/env dotnet-script
#nullable enable

class TreeNode
{
    public int val;

    public List<TreeNode> children;

    public TreeNode(int val, TreeNode? child1 = null, TreeNode? child2 = null)
    {
        this.val = val;
        this.children = new List<TreeNode>();
        if (child1 != null)
        {
            this.children.Add(child1);
        }
        if (child2 != null)
        {
            this.children.Add(child2);
        }
    }

    public bool IsLeaf()
    {
        return this.children.Count == 0;
    }
}

class Solution
{
    private int CountLeafs(TreeNode root)
    {
        int count = 0;
        count++;
        for (int i = 0; i < root.children.Count; i++)
        {
            count += CountLeafs(root.children[i]);
        }

        return count;
    }

    private void LevelOrderSpin(TreeNode root, int[] res, ref int pivot, Queue<TreeNode> currLevel, int levelWidth)
    {
        int nextLevelWidth = 0;
        bool breakOut = false;
        List<TreeNode> newCurrs = new();

        for (int i = 0; i < currLevel.Count; i++)
        {
            TreeNode currNode = currLevel.ElementAt(i);
            breakOut = currNode.children.Count == 0;
            for (int j = 0; j < currNode.children.Count; j++)
            {
                newCurrs.Add(currNode.children.ElementAt(j));
                nextLevelWidth++;
            }
        }

        for (int k = 0; k < newCurrs.Count; k++)
        {
            currLevel.Enqueue(newCurrs.ElementAt(k));
        }

        while (levelWidth-- > 0)
        {
            TreeNode temp = currLevel.Dequeue();
            res[pivot] = temp.val;
            pivot++;
        }
        if (breakOut) { return; }

        LevelOrderSpin(root, res, ref pivot, currLevel, nextLevelWidth);
    }

    public int[] LevelOrderRecursive(TreeNode root)
    {
        int resCount = CountLeafs(root);
        int[] res = new int[resCount];
        Queue<TreeNode> currLevel = new();
        currLevel.Enqueue(root);
        int pivot = 0;
        LevelOrderSpin(root, res, ref pivot, currLevel, 1);

        return res;
    }

    public int[] LevelOrder(TreeNode root)
    {
        int resCount = CountLeafs(root);
        int[] res = new int[resCount];
        int pivot = 0;
        bool runLoop = true;
        int levelWidth, count;
        Queue<TreeNode> current = new();
        List<TreeNode> newCurrs = [];
        current.Enqueue(root);

        while (runLoop)
        {
            runLoop = false;
            levelWidth = 0;
            newCurrs.Clear();
            foreach (TreeNode curr in current)
            {
                foreach (TreeNode child in curr.children)
                {
                    newCurrs.Add(child);
                    levelWidth++;
                    runLoop = true;
                }
            }

            for (int k = 0; k < newCurrs.Count; k++)
            {
                current.Enqueue(newCurrs.ElementAt(k));
            }

            count = current.Count - levelWidth;
            while (count-- > 0)
            {
                res[pivot] = current.Dequeue().val;
                pivot++;
            }
        }

        return res;
    }

    private void InOrderSpin(TreeNode root, int[] arr, int pivot)
    {
    }

    public int[] InOrderRecursive(TreeNode root)
    {
        return new int[] { };
    }

    public int[] InOrder(TreeNode root)
    {
        return new int[] { };
    }
    private void PreOrderSpin(TreeNode root, int[] arr)
    {
    }

    public int[] PreOrderRecursive(TreeNode root)
    {
        return new int[] { };
    }

    public int[] PreOrder(TreeNode root)
    {
        return new int[] { };
    }

    private void PostOrderSpin(TreeNode root, int[] arr, ref int pivot)
    {
        for (int i = 0; i < root.children.Count; i++)
        {
            PostOrderSpin(root.children[i], arr, ref pivot);
        }
        arr[pivot] = root.val;
        pivot++;
    }

    public int[] PostOrderRecursive(TreeNode root)
    {
        int resCount = CountLeafs(root);
        int[] res = new int[resCount];
        int pivot = 0;
        PostOrderSpin(root, res, ref pivot);

        return res;
    }

    public int[] PostOrder(TreeNode root)
    {
        return new int[] { };
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
int[] levelOrderExpected = new int[] { 10, 12, 5, 3, 4, 11, 2, 6, 7, 8 };
int[] inOrderExpected = new int[] { 3, 12, 6, 4, 7, 10, 11, 5, 2, 8 };
int[] preOrderExpected = new int[] { 10, 12, 3, 4, 6, 7, 5, 11, 2, 8 };
int[] postOrderExpected = new int[] { 3, 6, 7, 4, 12, 11, 8, 2, 5, 10 };

int[][] expectedArr = new int[][] { levelOrderExpected, inOrderExpected, preOrderExpected, postOrderExpected };

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

string[] names = new string[] { "levelOrder", "inOrder", "preOrder", "postOrder" };
for (int i = 0; i < expectedArr.Length; i++)
{
    Console.Write(names[i]);
    Console.Write("\n");
    Console.Write(string.Join(", ", expectedArr[i]));
    Console.Write("<-");
    Console.Write(string.Join(", ", solArray["recursive"][i]));
    Console.Write("\n");
    Console.Write(expectedArr[i].SequenceEqual(solArray["recursive"][i]) ? "true" : "false");
    Console.Write("\n");
    Console.Write(string.Join(", ", expectedArr[i]));
    Console.Write("<-");
    Console.Write(string.Join(", ", solArray["linear"][i]));
    Console.Write("\n");
    Console.Write(expectedArr[i].SequenceEqual(solArray["linear"][i]) ? "true" : "false");
    Console.Write("\n");
    Console.Write("-----------------------");
    Console.Write("\n");
}
