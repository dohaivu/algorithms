package study.string;

import java.util.Scanner;

/*
    1.2 Given two string, write a method to check if one is permutation of the other

    Hint: check Space, Case Sensitive
    O(n), S(1)
 */
public class Permutation {
    public static boolean checkPermutation(String a, String b) {
        if (a.length() != b.length()) return false;

        int[] result = new int[128];
        for (int i = 0; i < a.length(); i++) {
            result[a.charAt(i)]++;
            result[b.charAt(i)]--;
        }

        for (int i = 0; i < result.length; i++) {
            if (result[i] != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();
        System.out.println(checkPermutation(a, b));
    }
}
