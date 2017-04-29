package study;
import java.util.*;

public class Warmup {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        birthDayCakeCandle();
    }

    public static void inputArray() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        in.close();
    }

    public static void inputMatrix() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[][] = new int[n][n];
        for(int row=0; row < n; row++){
            for(int col = 0; col < n; col++)
                a[row][col] = in.nextInt();
        }
        in.close();

        for(int row=0; row < n; row++){
            for(int col = 0; col < n; col++)
                System.out.print(a[row][col] + " ");
            System.out.println();
        }
    }

    /**
     * https://www.hackerrank.com/challenges/birthday-cake-candles
     */
    public static void birthDayCakeCandle() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int height[] = new int[n];
        for(int height_i=0; height_i < n; height_i++){
            height[height_i] = in.nextInt();
        }
        in.close();

        int max = Integer.MIN_VALUE;
        int req = 0;
        for (int v: height) {
            if (v > max) {
                max = v;
                req = 1;
            } else if (v == max) {
                req++;
            }
        }

        System.out.println(req);
    }

    /**
     * https://www.hackerrank.com/challenges/time-conversion
     * 07:05:45PM
     * 19:05:45
     */
    public static void timeConversation() {
        Scanner in = new Scanner(System.in);
        String t = in.nextLine();
        in.close();

        String[] comp = t.split(":");
        String ampm = comp[2].substring(2);
        int hour = Integer.parseInt(comp[0]);
        if(ampm.equals("PM")) {
            hour += hour != 12 ? 12 : 0;
        }
        else if(hour == 12) {
            hour = 0;
        }

        System.out.printf("%02d:%s:%s\n", hour, comp[1], comp[2].substring(0, 2));
    }
    /**
     * https://www.hackerrank.com/challenges/mini-max-sum
     */
    public static void miniMaxSum() {
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        long b = in.nextLong();
        long c = in.nextLong();
        long d = in.nextLong();
        long e = in.nextLong();
        long[] arr = {a, b, c, d, e};
        in.close();

        long sum = 0;
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;

        // calculate sum
        for (long v: arr) {
            sum += v;

            if (min > v) min = v;
            else if (max < v) max = v;
        }

        System.out.println((sum - max) + " " + (sum-min));
    }
    /**
     * https://www.hackerrank.com/challenges/staircase
     */
    private static void printStairCase() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = "#";
        for (int i = 0; i < n; i++){
            // padding with spaces
            System.out.printf("%" +n+ "s\n", s);
            s += "#";
        }
        in.close();
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