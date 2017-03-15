package com.study;
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        lonelyInteger(a);
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

    private static void lonelyInteger(int[] a) {
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            result = result ^ a[i];
        }
        System.out.print(result);
    }
}