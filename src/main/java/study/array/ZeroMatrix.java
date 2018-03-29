package study.array;

import java.util.HashSet;
import java.util.Scanner;

import study.Utils;

/**
1.8 Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.

Find the row, col that has zero. Then loop again to zero the row, col
O(2*n*m), S(n*m)
 */
public class ZeroMatrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[][] A = new int[][] {
            { 7, 8, 9 },
            { 10, 0, 12 },
            { 1, 2, 3 }
        };

        Utils.printMatrix(A);

        zeroMatrix(A);
        Utils.printMatrix(A);

        in.close();
    }

    public static boolean zeroMatrix(int[][] a) {
        if (a.length == 0 || a[0].length == 0) return false;

        int n = a.length;
        int m = a[0].length;

        // find zero, loop entire matrix
        HashSet<Integer> rows = new HashSet<Integer>();
        HashSet<Integer> cols = new HashSet<Integer>();

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (a[row][col] == 0) {
                    rows.add(row);
                    cols.add(col);
                    System.out.println(String.format("%s %s", row, col));
                }
            }
        }

        // loop again to zero row, col
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (rows.contains(row) || cols.contains(col)) {
                    a[row][col] = 0;
                }
            }
        }

        return true;
    }
}