package study.string;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.*;

/**
 * two strings to be anagrams of each other if the first string's letters can be rearranged to form the second string
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
    }
}