/**
 * https://www.hackerrank.com/challenges/ctci-recursive-staircase
 */
package study.algorithm;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RecursionStairCase {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for(int a0 = 0; a0 < s; a0++){
            int n = in.nextInt();
            System.out.println(step(n));
        }
    }

    public static int step(int n) {
        int[] s = new int [4];
        s[0] = 0;
        s[1] = 1;
        s[2] = 2;
        s[3] = 4;
        if ( n <= 3) {
            return s[n];
        }
        for (int i = 4; i <= n; i++) {
            int si = s[3] + s[2] + s[1];
            s[1] = s[2];
            s[2] = s[3];
            s[3] = si;
        }

        return s[3];
    }
}
