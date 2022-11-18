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
            for(int j=startCol; i<startCol+3; i++){
                if (matrix[i][j] == num){
                    return false;
                }
            }

        return true;

    }

    public static void main(String[] args) {

        int[][] matrix = {
                {6,5,0,8,7,3,0,9,0},
                {0,0,3,2,5,0,0,0,8},
                {9,8,0,1,0,4,3,5,7},
                {1,0,5,0,0,0,0,0,0},
                {4,0,0,0,0,0,0,0,2},
                {0,0,0,0,0,0,5,0,3},
                {5,7,8,3,0,1,0,2,6},
                {2,0,0,0,4,8,9,0,0},
                {0,9,0,6,2,5,0,8,1}
        };

        print_sudoku(matrix);
    }
}