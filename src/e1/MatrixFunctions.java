package e1;

import java.util.*;

public class MatrixFunctions {

    // Returns the maximun value of a matrix
    public static int max(int[][] a) {
        boolean isInitialiced = false;
        int max = a[0][0];
        for (int[] arr : a) {
            for (int item : arr) {
                max = item > max ? item : max;
            }
        }
        return max;
    }

    // Returns the sum of the values of a given row
    public static int rowSum(int[][] a, int row) {
        int sum = 0;

        for (int actual : a[row]) {
            sum += actual;
        }

        return sum;
    }

    // Returns the sum of the values of a given column
    public static int columnSum(int[][] a, int column) {
        int suma = 0;

        for (int[] a1 : a) {
            if (column < a1.length) {
                suma += a1[column];
            }
        }

        return suma;
    }

    // Sums the value of each row and returns the results in an array .
    public static int[] allRowSums(int[][] a) {
        int[] suma = new int[a.length];
        for (int i = 0; i < a.length; i++) {

            suma[i] = MatrixFunctions.rowSum(a, i);
        }

        return suma;
    }

    // Sums the value of each column and returns the results in an array .
    // If a position does not exist because the array is " ragged " that position
    // is considered a zero value .
    public static int[] allColumnSums(int[][] a) {
        int maxColumn = 0;
        for (int[] a1 : a) {
            int longitud = a1.length;
            maxColumn = maxColumn < longitud ? longitud : maxColumn;
        }
        int[] suma = new int[maxColumn];
        for (int i = 0; i < maxColumn; i++) {
            suma[i] = MatrixFunctions.columnSum(a, i);
        }
        return suma;
    }

    // Checks if an array is "row - magic ", that is , if all its rows have the same
    // sum of all its values .
    public static boolean isRowMagic(int[][] a) {
        boolean isMagic = true;
        int[] rows = MatrixFunctions.allRowSums(a);
        int firstRowSum = rows[0];
        for (int row : rows) {
            if (row != firstRowSum) {
                return false;
            }
        }
        return true;
    }

    // Checks if an array is " column - magic ", that is , if all its columns have
    // the same sum of all its values .
    public static boolean isColumnMagic(int[][] a) {
        boolean isMagic = true;
        int[] cols = MatrixFunctions.allColumnSums(a);
        int firstColSum = cols[0];
        for (int col : cols) {
            if (col != firstColSum) {
                return false;
            }
        }
        return true;
    }

    // Checks that a matrix is square , that is , it has the same number of rows
    // as columns and all rows have the same length .
    public static boolean isSquare(int[][] a) {
        int maxColumn = 0;
        int numRows = a.length;
        for (int[] a1 : a) {
            int longitud = a1.length;
            if (longitud != numRows) {
                return false;
            }
        }
        return true;
    }

    // Check if the matrix is a magic square . A matrix is magic square if it is
    // square , all the rows add up to the same , all the columns add up to the
    // same and the two main diagonals add up to the same . Also all these sums
    // are the same .
    public static boolean isMagic(int[][] a) {
        int suma = 0;
        int suma2 = 0;
        if (MatrixFunctions.isSquare(a)) {
            for (int i = 0; i < a.length; i++) {
                suma += a[i][i];
            }
            for (int i = a.length-1; i >= 0; i--) {
                suma2 += a[i][i];
            }
            if (suma != suma2) {
                return false;
            }
            if (MatrixFunctions.isRowMagic(a)) {
                if (suma == MatrixFunctions.rowSum(a, 0)) {
                    if (MatrixFunctions.isColumnMagic(a)) {
                        if (MatrixFunctions.columnSum(a, 0) == suma) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    // Checks if the given matrix forms a sequence , that is , it is square
    // (of order n) and contains all the digits from 1 to n * n, regardless of
    // their order .
    public static boolean isSequence(int[][] a) {
        int i = 1;
        boolean isSequence = true;
        boolean currentSequence;
        int maxRow = a.length;
        int totalLength = maxRow * maxRow;
        if (MatrixFunctions.isSquare(a)) {
            while (i < totalLength) {
                currentSequence = false;
                for (int[] row : a) {
                    for (int col : row) {
                        currentSequence = currentSequence || (col == i);
                    }
                }
                isSequence = isSequence && currentSequence;
                i++;
            }
            return isSequence;
        }
        return false;
    }
}
