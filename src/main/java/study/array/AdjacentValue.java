package study.array;

import java.io.Console;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class AdjacentValue {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String a = in.nextLine();
        int[] A = new int[8];
        A[0] = 0;
        A[1] = 3;
        A[2] = 3;
        A[3] = 7;
        A[4] = 5;
        A[5] = 3;
        A[6] = 11;
        A[7] = 1;

        calculateAdjacentValue(A);
    }

    private static void calculateAdjacentValue(int[] A) {
        int value = 0;
        int k = 0;
        int i = 0;
        int j = 0;

        Arrays.sort(A);

        for (i = 0; i < A.length - 1; i++) {
            for (j = i + 1; j < A.length; j++) {
                value = value + Math.abs(A[i] - A[j]);
                System.out.println(String.format("%d(%d) %d(%d)",i, A[i], j, A[j]));
                if (A[j] > A[i]) {
                    break;
                }
            }


        }
        System.out.println();
        System.out.println(value);
    }
}
