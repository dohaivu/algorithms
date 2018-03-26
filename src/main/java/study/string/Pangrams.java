package study.string;

import java.util.Scanner;

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