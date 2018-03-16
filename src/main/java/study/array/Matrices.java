package study.array;

/*
 * If A is a x * y matrix and B is a y * z matrix,
 * matrix C is the result of multiplication of A * B,
 * in which the y entries across a row of A are multiplied
 * with the y entries down a columns of B
 * and summed to produce an entry of C.
 */

import study.Utils;

class Matrices {

    public static int[][] Multiply(int[][] multiplicand, int[][] multiplier) throws Exception{

        if (multiplicand.length == 0 ||
            multiplier.length == 0 ||
            multiplicand.length != multiplier[0].length ||
            multiplicand[0].length != multiplier.length)
            throw new Exception("Invalid matrices size");

        int[][] multiplied = new int[multiplicand.length][multiplier[0].length];

        // This text editor is recording as you type.
        // Write your code here, in this text editor, without copy-pasting,
        // so that we can follow your process.
        // Consider handling invalid input parameters.

        for (int i = 0; i < multiplicand.length; i++) {
            for (int j = 0; j < multiplier[0].length; j++) {
                for (int k = 0; k < multiplicand[0].length; k++) {
                    multiplied[i][j] += multiplicand[i][k] * multiplier[k][j];
                }
            }
        }

        return multiplied;
    }

    public static void main(String args[] ) throws Exception {

        int[][] A = new int[][] {

        };

        int[][] B = new int[][] {
            { 7, 8, 9 },
            { 10, 11, 12 }
        };

        int[][] C = Multiply(A, B);

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < C[0].length; j++) {
                System.out.println("C[" + i + "][" + j + "] = " + C[i][j]);
            }
        }

        Utils.printMatrix(C);
    }

}
