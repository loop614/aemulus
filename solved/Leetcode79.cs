/*
79. Word Search
Medium
Given an m x n grid of characters board and a string word, return true if word exists in the grid.
The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
ToDo: Style, try recursion
*/
class Point : IEquatable<Point>
{
    public int i;
    public int j;

    public Point(int i, int j)
    {
        this.i = i;
        this.j = j;
    }

    public bool Equals( Point? that )
    {
        if (that is null) { return false; }

        return this.i == that.i &&
               this.j == that.j;
    }
}

class LoopState
{
    public Point[] path;

    public int tempi;

    public int tempj;

    public int pivot;

    public LoopState(Point[] path, int tempi, int tempj, int pivot)
    {
        this.path = path;
        this.tempi = tempi;
        this.tempj = tempj;
        this.pivot = pivot;
    }

    public LoopState(int cap)
    {
        this.path = new Point[cap];
        this.tempi = 0;
        this.tempj = 0;
        this.pivot = 0;
    }
}

public class Solution
{
    public bool Exist(char[][] board, string word)
    {
        if (word.Length == 1)
        {
            for (int j = 0; j < board[0].Length; j++)
            {
                for (int i = 0; i < board.Length; i++)
                {
                    if (board[i][j] == word[0])
                    {
                        return true;
                    }
                }
            }
            return false;
        }

        int pivot = 0;
        Queue<LoopState> que = new();
        for (int j = 0; j < board[0].Length; j++)
        {
            for (int i = 0; i < board.Length; i++)
            {
                if (board[i][j] == word[pivot])
                {
                    LoopState first = new(word.Length);
                    first.path[pivot] = new Point(i, j);
                    first.tempi = i;
                    first.tempj = j;
                    first.pivot = 1;
                    que.Enqueue(first);

                    int queLevelCount = 1;


                    while (que.Count > 0)
                    {
                        while (queLevelCount-- > 0)
                        {
                            LoopState curr = que.Dequeue();
                            bool lastletter = curr.pivot + 1 == word.Length;

                            if (curr.tempi - 1 >= 0 && board[curr.tempi - 1][curr.tempj] == word[curr.pivot] && !Array.Exists<Point>(curr.path, element => element is not null && element.i == curr.tempi - 1 && element.j == curr.tempj))
                            {
                                if (lastletter) { return true; }
                                Point[] temp = new Point[word.Length];
                                Array.Copy(curr.path, 0, temp, 0, curr.pivot + 1);
                                temp[curr.pivot] = new Point(curr.tempi - 1, curr.tempj);
                                que.Enqueue(new LoopState(temp, curr.tempi - 1, curr.tempj, curr.pivot + 1));
                            }

                            if (curr.tempj - 1 >= 0 && board[curr.tempi][curr.tempj - 1] == word[curr.pivot] && !Array.Exists<Point>(curr.path, element => element is not null && element.i == curr.tempi && element.j == curr.tempj - 1))
                            {
                                if (lastletter) { return true; }
                                Point[] temp = new Point[word.Length];
                                Array.Copy(curr.path, 0, temp, 0, curr.pivot + 1);
                                temp[curr.pivot] = new Point(curr.tempi, curr.tempj - 1);
                                que.Enqueue(new LoopState(temp, curr.tempi, curr.tempj - 1, curr.pivot + 1));
                            }

                            if (curr.tempj + 1 < board[curr.tempi].Length && board[curr.tempi][curr.tempj + 1] == word[curr.pivot] && !Array.Exists<Point>(curr.path, element => element is not null && element.i == curr.tempi && element.j == curr.tempj + 1))
                            {
                                if (lastletter) { return true; }
                                Point[] temp = new Point[word.Length];
                                Array.Copy(curr.path, 0, temp, 0, curr.pivot + 1);
                                temp[curr.pivot] = new Point(curr.tempi, curr.tempj + 1);
                                que.Enqueue(new LoopState(temp, curr.tempi, curr.tempj + 1, curr.pivot + 1));
                            }

                            if (curr.tempi + 1 < board.Length && board[curr.tempi + 1][curr.tempj] == word[curr.pivot] && !Array.Exists<Point>(curr.path, element => element is not null && element.i == curr.tempi + 1 && element.j == curr.tempj))
                            {
                                if (lastletter) { return true; }
                                Point[] temp = new Point[word.Length];
                                Array.Copy(curr.path, 0, temp, 0, curr.pivot + 1);
                                temp[curr.pivot] = new Point(curr.tempi + 1, curr.tempj);
                                que.Enqueue(new LoopState(temp, curr.tempi + 1, curr.tempj, curr.pivot + 1));
                            }
                        }
                        queLevelCount = que.Count;
                    }
                }
                pivot = 0;
            }
        }


        return false;
    }
}

Solution sol = new Solution();
bool output;
char[][] board;
string word;

board = [['A', 'B', 'C', 'E'], ['S', 'F', 'C', 'S'], ['A', 'D', 'E', 'E']];
word = "ABCB";
output = sol.Exist(board, word);
Console.WriteLine(output == false);

board = [['A']];
word = "A";
output = sol.Exist(board, word);
Console.WriteLine(output == true);

board = [['A', 'B', 'C', 'E'], ['S', 'F', 'C', 'S'], ['A', 'D', 'E', 'E']];
word = "SEE";
output = sol.Exist(board, word);
Console.WriteLine(output == true);

board = [['A', 'B', 'C', 'E'], ['S', 'F', 'C', 'S'], ['A', 'D', 'E', 'E']];
word = "ABCCED";
output = sol.Exist(board, word);
Console.WriteLine(output == true);
