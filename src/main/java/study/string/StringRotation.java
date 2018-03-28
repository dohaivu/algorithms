package study.string;

import java.util.Scanner;

/*
1.1 Assumeyou have a method isSubstringwhich checks if one word is a substring of another. Given two strings, sl and s2, write code to check if s2 is a rotation of sl using only one call to isSubstring (e.g.,"waterbottle" is a rotation of"erbottlewat").
- Input
waterbottle
erbottlewat
- Output
true
- Explanation
second string rotate first string

Loop 1st string to find the beginning of 2st string
Loop 2st string to check the chars
O(n*n)
 */
public class StringRotation {
     public static boolean checkStringRotation(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        int j = 1;
        for (int i = 0; i < str1.length(); i++) {
            int val = str1.charAt(i);
            if (val == str2.charAt(0)) {
                for (j = 1; j < str2.length(); j++) {
                    if (str2.charAt(j) != str1.charAt((i + j)%str1.length()))
                        break;
                }

                if (j == str2.length()) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();

        System.out.println(checkStringRotation(a, b));

        in.close();
    }
}
