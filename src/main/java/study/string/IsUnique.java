package study.string;

import java.util.Scanner;

/*
    1.1 A string has all unique character
    - Input
    abca
    abc
    - Output
    false
    true
    - Explanation

    Use array hold the appearance of characters
    O(n)
 */
public class IsUnique {
     public static boolean isUniqueChars(String str) {
        if (str.length() == 0) return true;
        if (str.length() > 128) return false;

        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) return false;
            char_set[val] = true;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        System.out.println(isUniqueChars(a));

        in.close();
    }
}
