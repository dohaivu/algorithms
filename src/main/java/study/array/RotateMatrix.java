package study.array;

import java.util.Scanner;

import study.Utils;

/**
1.7 Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees

O(n*m), S(n*m)
 */
public class RotateMatrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[][] A = new int[][] {
            { 7, 8, 9 },
            { 10, 11, 12 },
            { 1, 2, 3 }
        };

        Utils.printMatrix(A);

        rotateMatrix(A);
        Utils.printMatrix(A);

        rotateMatrix(A);
        Utils.printMatrix(A);

        in.close();
    }

    public static boolean rotateMatrix(int[][] a) {
        if (a.length == 0 || a.length != a[0].length) return false;

        int n = a.length;
        for (int layer = 0; layer < n/2; layer++) {
            int first = layer;
            int last = n - 1 - layer;

            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = a[first][i];
                a[first][i] = a[last-offset][first];
                a[last-offset][first] = a[last][last-offset];
                a[last][last-offset] = a[i][last];
                a[i][last] = top;
            }
        }

        return true;
    }
}