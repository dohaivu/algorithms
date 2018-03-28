package study.string;

import java.util.Scanner;

/*
1.6 Implement a method to perform basic string compression using the counts of repeated characters.
For example, the string aabcccccaaa would become a2blc5a3.
If the "compressed" string would not become smaller than the original string, your method should return the original string.
You can assume the string has only uppercase and lowercase letters (a - z).

Use an array to hold new value. An counter to count character
Loop  and compare the current char with the next, then increase, reset the counter.
O(n), S(2n)
 */
public class StringCompression {
    public static String compressString(String a) {
        StringBuilder sb = new StringBuilder();
        int count =  1;
        for (int i = 0; i < a.length(); i++) {
            if (i < (a.length() - 1) && a.charAt(i) == a.charAt(i + 1)) {
                count++;
            } else {
                sb.append(a.charAt(i));
                sb.append(count);
                count = 1;
            }
        }

        if (sb.length() < a.length()) return sb.toString();
        else return a;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        System.out.println(compressString(a));

        in.close();
    }
}
