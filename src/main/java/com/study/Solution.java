package com.study;
import java.io.*;
import java.text.NumberFormat;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        leftRotation();
    }

    /**
     * https://www.hackerrank.com/challenges/ctci-array-left-rotation
     * in
     * 5 4
     * 1 2 3 4 5
     * out
     * 5 1 2 3 4
     */
    private static void leftRotation() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        if (k > n) k = k - n;
        if ( k == 0)
            Arrays.stream(a).forEach(s -> System.out.print(s + " "));

        // rotate
        int b[] = new int[n];
        for (int b_i = 0; b_i < n; b_i++) {
            int i = (b_i + k) % n;
            b[b_i] = a[i];
        }
        ;
NumberFormat.getCurrencyInstance(new Locale("en_IN");
        Arrays.stream(b).forEach(s -> System.out.print(s + " "));
    }

    private static void flipBit() {
        long maxValue = 4294967295L;
        Scanner in = new Scanner(System.in);
        int row = Integer.parseInt(in.nextLine());
        for (int i = 0; i < row; i++) {
            int input = Integer.parseInt(in.nextLine());
            System.out.println(maxValue ^ input);
        }

        in.close();
    }

    private static void lonelyInteger() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        int result = 0;
        for (int i = 0; i < a.length; i++) {
            result = result ^ a[i];
        }
        System.out.print(result);
        in.close();
    }
}