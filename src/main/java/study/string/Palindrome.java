package study.string;
// A palindrome is a word which reads the same backward as forward, such as 'madam' or 'racecar'.

public class Palindrome {

    public static boolean isPalindrome(String wordString) {

        boolean isPalindrome = true;

        // This text editor is recording as you type.
        // Write your code here, in this text editor, without copy-pasting,
        // so that we can follow your process.
        // Consider handling invalid input parameters.
        // PLEASE DO NOT USE BUILT IN STRING FUNCTIONS!

        if (wordString == null || wordString.length() == 0) return false;
        if (wordString.length() == 1) return true;

        int i = 0;
        int j = wordString.length() - 1 ;
        while (j > i) {
            if (wordString.charAt(i) != wordString.charAt(j)) {
                isPalindrome = false;
            }
            i++;
            j--;
        }

        return isPalindrome;
    }

    public static void main(String args[] ) throws Exception {
        System.out.println("isPalindrome(\"\") = " + (isPalindrome("") ? "YES" : "NO"));
        System.out.println("isPalindrome(\"a\") = " + (isPalindrome("a") ? "YES" : "NO"));
        System.out.println("isPalindrome(\"mad\") = " + (isPalindrome("mad") ? "YES" : "NO"));
        System.out.println("isPalindrome(\"madam\") = " + (isPalindrome("madam") ? "YES" : "NO"));
        System.out.println("isPalindrome(\"race\") = " + (isPalindrome("race") ? "YES" : "NO"));
        System.out.println("isPalindrome(\"racecar\") = " + (isPalindrome("racecar") ? "YES" : "NO"));

    }

}
