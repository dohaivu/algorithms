/**
 * https://www.hackerrank.com/challenges/ctci-bubble-sort
 */

package study.algorithm;

import java.util.*;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        int totalSwap = sort(a);
        System.out.println(String.format("Array is sorted in %d swaps.", totalSwap));
        System.out.println("First Element:" + a[0]);
        System.out.println("Last Element:" + a[a.length - 1]);

        Arrays.stream(a).forEach(s -> System.out.print(s + " "));

        in.close();
    }

    public static int sort(int[] inputs) {
        int totalSwap = 0;
        for (int i = 0; i < inputs.length; i++) {
            int numberOfSwaps = 0;
            for (int j = 0; j < inputs.length - 1; j ++) {
                if (inputs[j] > inputs[j + 1]) {
                    int temp = inputs[j];
                    inputs[j] = inputs[j + 1];
                    inputs[j + 1] = temp;

                    numberOfSwaps++;
                    totalSwap++;
                }
            }

            if (numberOfSwaps == 0) {
                break;
            }
        }

        return totalSwap;
    }
}