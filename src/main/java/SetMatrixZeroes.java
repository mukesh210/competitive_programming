/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 */
public class SetMatrixZeroes {
    public static void main(String args[]) {
        SetMatrixZeroes smz = new SetMatrixZeroes();
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        //smz.setZeroes(matrix);
        smz.setZeroes1(matrix);

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void setZeroes1(int[][] matrix) {
        boolean zerothRowContainsZero = false;
        boolean zerothColContainsZero = false;

        for(int i = 0; i < matrix[0].length; i++) {
            if(matrix[0][i] == 0) {
                zerothRowContainsZero = true;
                break;
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] == 0) {
                zerothColContainsZero = true;
                break;
            }
        }

        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < matrix[0].length; i++) {
            if(matrix[0][i] == 0) {
                for(int j = 1; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        for(int i = 1; i < matrix.length; i++) {
            if(matrix[i][0] == 0) {
                for(int j = 1; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(zerothRowContainsZero) {
            for(int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        if(zerothColContainsZero) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public void setZeroes(int[][] matrix) {
        boolean[] rows = new boolean[matrix.length];
        boolean[] cols = new boolean[matrix[0].length];

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(rows[i] || cols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
