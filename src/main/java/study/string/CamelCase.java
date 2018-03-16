package study.string;

import java.util.Scanner;

/**
 * Make a string "This is a camel case" to "ThisIsACamelCase"
 */
public class CamelCase {
    public static String makeCamelCase(String a) {
        char[] charArray = a.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ' ') {

            }
        }

        return "";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        System.out.println(makeCamelCase(a));
    }
}
