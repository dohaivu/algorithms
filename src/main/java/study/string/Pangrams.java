package study.string;

import java.util.Scanner;

/**
 * pangrams are sentences constructed by using every letter of the alphabet at least once.
 - Input Format
 Input consists of a line containing s.

 - Constraints
 Length of s can be atmost 103 (1≤|s|≤103) and it may contain spaces, lowercase and uppercase letters. Lowercase and uppercase instances of a letter are considered same.

 - Output Format
 Output a line containing pangram if s is a pangram, otherwise output not pangram.

 Ex:
 We promptly judged antique ivory buckles for the next prize
 -> pangram

 We promptly judged antique ivory buckles for the prize
 -> not pangram

 - Explanation
 In the first testcase, the answer is pangram because the sentence contains
 all the letters.

 Use an array[26] to hold alphabe characters
 */
public class Pangrams {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();

        if (isPangram(a)) {
            System.out.println("pangram");
        } else {
            System.out.println("not pangram");
        }
        in.close();
    }

    private static Boolean isPangram(String s) {
        boolean[] value = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (c < 'a')
                value[s.charAt(i) - 'a' + 32] = true;
            else
                value[s.charAt(i) - 'a'] = true;
        }

        for (int i = 0; i < 26; i++) {
            if (!value[i]) return false;
        }

        return true;
    }
}