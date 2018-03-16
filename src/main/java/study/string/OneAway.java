package study.string;

import java.util.Scanner;

/*
1.5 There are three types of edits that can be performed on strings: insert a character, remove a character, or replace a character.
Given two strings, write a function to check if they are one edit (or zero edits) away
 */
public class OneAway {
    public static boolean checkOneAway(String a, String b) {
        if (Math.abs(a.length() - b.length()) > 1) return false;

        int i = 0;
        int j = 0;
        int count = 0;
        while (true) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            } else {
                if (i < a.length() - 1 && a.charAt(i + 1) == b.charAt(j)) {
                    i++;
                } else if (j < b.length() - 1 && a.charAt(i) == b.charAt(j + 1)) {
                    j++;
                } else {
                    i++;
                    j++;
                }

                count++;
            }

            if (count >= 2) return false;
            if (i == a.length() || j == b.length()) break;
        }


        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();
        System.out.println(checkOneAway(a, b));
    }
}
