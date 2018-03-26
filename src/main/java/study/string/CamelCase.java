package study.string;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Make a string "This is a camel case" to "ThisIsACamelCase"
 * Use 2 index: read, write
 * O(n)
 */
public class CamelCase {
    public static String makeCamelCase(String a) {
        if (a.length() == 0) return a;

        char[] charArray = a.toCharArray();
        int j = 0;
        boolean isSpace = true;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != ' ') {
                if (isSpace)
                    charArray[j++] = Character.toUpperCase(charArray[i]);
                else
                    charArray[j++] = charArray[i];

                isSpace = false;
            } else {
                isSpace = true;
            }
        }

        return new String(Arrays.copyOf(charArray, j));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        System.out.println(makeCamelCase(a));
        in.close();
    }
}
