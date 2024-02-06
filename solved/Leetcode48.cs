public class Solution {
    private (int, int) Minus90(int i, int j, int count)
    {
        // 0, 0 -> 2, 0
        // 0, 2 -> 0, 0
        // 2, 2 -> 0, 2
        // 2, 0 -> 2, 2

        // 0, 1 -> 1, 0
        // 1, 2 -> 0, 1
        // 2, 1 -> 1, 2
        // 1, 0 -> 2, 1
        return (count - 1 - j, i);
    }

    private (int, int) Plus90(int i, int j, int count)
    {
        // 0, 0 -> 0, 2
        // 0, 2 -> 2, 2
        // 2, 2 -> 2, 0
        // 2, 0 -> 0, 0

        // 0, 1 -> 1, 2
        // 1, 2 -> 2, 1
        // 2, 1 -> 1, 0
        // 1, 0 -> 0, 1
        return (j, count - 1 - i);
    }

    /*
    58%
    46%
    */
    public void RotateUsingRotates(int[][] matrix) {
        int colCount = matrix[0].Length;
        int rowCount = matrix.Length;
        int previous, temp, posx, posy, tempposx, tempposy;
        for(int i = 0; i < rowCount / 2 + 1; i++) {
            for(int j = i; j < colCount - i - 1; j++) {
                posx = i;
                posy = j;
                (tempposx, tempposy) = Minus90(posx - i , posy - i, colCount - 2*i);
                previous = matrix[tempposx + i][tempposy + i];

                for(int k = 0; k < 4; k++) {
                    temp = matrix[posx][posy];
                    matrix[posx][posy] = previous;
                    previous = temp;
                    (posx, posy) = Plus90(posx, posy, colCount);
                }
            }
        }
    }

    /*
    51%
    69%
    */
    public void RotateWithHelperMatrix(int[][] matrix) {
        int colCount = matrix[0].Length;
        int rowCount = matrix.Length;
        int[][] matrixHelp = new int[rowCount][];
        for( int i =0; i < rowCount; i++ ) {
            matrixHelp[i] = new int[colCount];
        }

        for(int i = 0; i < rowCount; i++) {
            for(int j = 0; j < colCount; j++) {
                matrixHelp[i][j] = matrix[colCount-1-j][i];
            }
        }

        for(int i = 0; i < rowCount; i++) {
            for(int j = 0; j < colCount; j++) {
                matrix[i][j] = matrixHelp[i][j];
            }
        }
    }

    /*
    76%
    9%
    */
    public void Rotate(int[][] matrix) {
        int colCount = matrix[0].Length;
        int rowCount = matrix.Length;
        int previous, temp, posx, posy, posxp;
        for(int i = 0; i < rowCount / 2 + 1; i++) {
            for(int j = i; j < colCount - i - 1; j++) {
                posx = i;
                posy = j;
                previous = matrix[colCount - 1 - posy][posx];

                for(int k = 0; k < 4; k++) {
                    temp = matrix[posx][posy];
                    matrix[posx][posy] = previous;
                    previous = temp;

                    posxp = posx;
                    posx = posy;
                    posy = colCount - 1 - posxp;
                }
            }
        }
    }
}

void PrintMatrix(int[][] matrix)
{
    foreach(var one in matrix) {
        foreach(var second in one) {
            Console.Write(second);
            Console.Write("\t");
        }
        Console.Write("\n");
    }
}


var sol = new Solution();
int[][] matrix;
matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]];
PrintMatrix(matrix);
Console.Write("\n");
sol.Rotate(matrix);
PrintMatrix(matrix);
Console.Write("\n");

matrix = [[1,2,3],[4,5,6],[7,8,9]];
PrintMatrix(matrix);
Console.Write("\n");
sol.Rotate(matrix);
PrintMatrix(matrix);
Console.Write("\n");
