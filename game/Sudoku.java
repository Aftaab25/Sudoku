package game;

class Sudoku{

    final static int SIZE = 9;

    private static void print_sudoku(int[][] matrix){
        for(int i=0; i<SIZE; i++){
            for(int j=0; j<SIZE; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
            System.out.println();
        }
    }

    private static boolean is_safe(int[][] matrix, int num, int row, int col){
        for(int i=0; i<SIZE; i++) {
            if (matrix[row][i] == num){
                return false;
            }
        }
        for (int j = 0; j < SIZE; j++) {
            if (matrix[j][col] == num){
                return false;
            }
        }

        // checking fot the sub-matrix
        // 0 1 2 3 4

        // 4 -> 3
        // 4 - 4 % 3 = 1
        // row - row%3


        int startRow = row - (row % 3);
        int startCol = col - (col % 3);

        for(int i=startRow; i<startRow+3; i++)
            for(int j=startCol; j<startCol+3; j++){
                if (matrix[i][j] == num){
                    return false;
                }
            }

        return true;
    }

    private static boolean solve_sudoku(int[][] matrix, int row, int col){
        if (row == SIZE-1 && col == SIZE){
            return true;
        }

        if (col == SIZE){
            row++;
            col = 0;
        }

        if (matrix[row][col] != 0){
            return solve_sudoku(matrix, row, col+1);
        }

        for (int i=1; i<SIZE+1; i++){
            if (is_safe(matrix, i, row, col)){
                matrix[row][col] = i;

                if (solve_sudoku(matrix, row, col+1)){
                    return true;
                }

            }
            matrix[row][col] = 0;
        }
        return false;
    }

    public static void main(String[] args) {

        int matrix[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

        if (solve_sudoku(matrix, 0, 0))
            print_sudoku(matrix);
        else System.out.println("Oops! No Solution Exists!");
    }
}