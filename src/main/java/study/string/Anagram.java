package study.string;

import java.util.HashMap;
import java.util.Scanner;

/**
Alice is taking a cryptography class and finding anagrams to be very useful. We consider two strings to be anagrams of each other if the first string's letters can be rearranged to form the second string. In other words, both strings must contain the same exact letters in the same exact frequency For example, bacdc and dcbac are anagrams, but bacdc and dcbad are not.

Alice decides on an encryption scheme involving two large strings where encryption is dependent on the minimum number of character deletions required to make the two strings anagrams. Can you help her find this number?

Given two strings, a and b, that may or may not be of the same length, determine the minimum number of character deletions required to make a and b anagrams. Any characters can be deleted from either of the strings.

- Input
cde
abc
- Output
4
- Explanation
We delete the following characters from our two strings to turn them into anagrams of each other:

Remove d and e from cde to get c.
Remove a and b from abc to get c.
We must delete 4 characters to make both strings anagrams, so we print 4 on a new line.
 */
public class Anagram {
    /**
     * https://www.hackerrank.com/challenges/ctci-making-anagrams
     */
    public static int numberNeeded(String first, String second) {
        if (first.length() == 0) return second.length();
        if (second.length() == 0) return first.length();

        HashMap<Character, Integer> charCount = new HashMap<>();

        for (int i = 0; i < first.length(); i++) {
            int count = 0;
            char c = first.charAt(i);
            if (charCount.containsKey(c)) {
                count = charCount.get(c);
            }
            charCount.put(c, ++count);
        }

        for (int i = 0; i < second.length(); i++) {
            char c = second.charAt(i);
            int count =0;
            if (charCount.containsKey(c)) {
                count = charCount.get(c);
            }
            charCount.put(c, --count);
        }

        int result = 0;
        for (int v: charCount.values()) {
            result += Math.abs(v);
        }
        return result;

    }

    public static int numberNeeded2(String first, String second) {
		int[] lettercounts = new int[26];
		for(char c : first.toCharArray()){
			lettercounts[c-'a']++;
		}
		for(char c : second.toCharArray()){
			lettercounts[c-'a']--;
		}
		int result = 0;
		for(int i : lettercounts){
			result += Math.abs(i);
		}
		return result;
	}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));

        in.close();
    }
}