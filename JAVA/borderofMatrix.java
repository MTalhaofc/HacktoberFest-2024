public class MatrixBorder {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        printBorderClockwise(matrix);
    }

    static void printBorderClockwise(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        for (int i = 0; i < cols; i++) System.out.print(matrix[0][i] + " ");
        for (int i = 1; i < rows; i++) System.out.print(matrix[i][cols - 1] + " ");
        if (rows > 1) for (int i = cols - 2; i >= 0; i--) System.out.print(matrix[rows - 1][i] + " ");
        if (cols > 1) for (int i = rows - 2; i > 0; i--) System.out.print(matrix[i][0] + " ");
    }
}
