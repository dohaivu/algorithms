package study.string;

import java.util.Scanner;

/*
    1.3 urlify a string, replace spaces with %20

    An array[4x] to hold new String
    Loop and check space
    Hint: check Space, Case Sensitive
    O(n), S(n)
 */
public class Urlify {
    public static String urlify(String str, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                if (i < str.length() - 1 && str.charAt(i + 1) != ' ')
                    sb.append("%20");
                continue;
            } else {
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        System.out.println(urlify(a, a.length()));

        in.close();
    }
}
