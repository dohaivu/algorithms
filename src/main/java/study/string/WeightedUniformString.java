package study.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
https://www.hackerrank.com/challenges/weighted-uniform-string/problem

A weighted string is a string of lowercase English letters where each letter has a weight in the inclusive range from 1 to 26

loop to calc the sum, compare prev char
Use HashSet to hold the value, cheap to lookup
O(n), S(n)
 */
public class WeightedUniformString {

    public static String[] weightedUniformStrings(String s, int[] queries) {

        String[] result = new String[queries.length];

        // calcutate weighted sum
        char[] chars = s.toCharArray();
        HashSet<Integer> sums = new HashSet<>();

        char prevChar = 0;
        Integer prevSum = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == prevChar) {
                prevSum = prevSum + (chars[i] - 'a' + 1);

            } else {
                prevSum = chars[i] - 'a' + 1;
            }
            sums.add(prevSum);
            prevChar = chars[i];
        }

        for (int i = 0; i < queries.length; i++) {
            if (sums.contains(queries[i])) {
                result[i] = "Yes";
            } else {
                result[i] = "No";
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();

        int queriesCount = Integer.parseInt(in.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(in.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        String[] result = weightedUniformStrings(s, queries);

        for (String str: result) {
            System.out.println(str);
        }

        in.close();
    }
}