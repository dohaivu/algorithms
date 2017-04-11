/**
https://www.hackerrank.com/challenges/ctci-ransom-note

A kidnapper wrote a ransom note but is worried it will be traced back to him. He found a magazine and wants to know if he can cut out whole words from it and use them to create an untraceable replica of his ransom note. The words in his note are case-sensitive and he must use whole words available in the magazine, meaning he cannot use substrings or concatenation to create the words he needs.
Given the words in the magazine and the words in the ransom note, print Yes if he can replicate his ransom note exactly using whole words from the magazine; otherwise, print No.

Input Format:
The first line contains two space-separated integers describing the respective values of  (the number of words in the magazine) and  (the number of words in the ransom note).
The second line contains  space-separated strings denoting the words present in the magazine.
The third line contains  space-separated strings denoting the words present in the ransom note.

Constraints:
Each word consists of English alphabetic letters
The words in the note and magazine are case-sensitive.

Output Format:
Print Yes if he can use the magazine to create an untraceable replica of his ransom note; otherwise, print No.

Sample Input:
6 4
give me one grand today night
give one grand today

Sample Output:
Yes

Explanation:
All four words needed to write an untraceable replica of the ransom note are present in the magazine, so we print Yes as our answer.
*/
package study.string;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import study.Solution;

public class RansomeNote {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
        }


        Boolean result = solve(magazine, ransom);
        if (result)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    /**
     * Complexity: 2 loop -> 2n -> n
     */
    public static boolean solve(String[] maganize, String[] ransome) {
        if (maganize.length == 0 || ransome.length == 0) return false;

        HashMap<String, Integer> wordCounts = new HashMap<>();
        for (String w: maganize) {
            Integer count = wordCounts.get(w);
            wordCounts.put(w, (count == null? 1 : ++count));
        }

        for (String w: ransome) {
            Integer count = wordCounts.get(w);
            if (count == null || count <= 0) {
                return false;
            } else {
                wordCounts.put(w, --count);
            }
        }

        return true;
    }
}