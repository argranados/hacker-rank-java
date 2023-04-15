package com.ciberaccion.ipk.string.anagrams;

public class Solution {

    public static void main(String[] args) {
        String wordOne = "cde"; String wordTwo = "abc";
        int r = Result.makeAnagram(wordOne, wordTwo);
        System.out.println("result "+r);
    }
}

class Result{
    public static int makeAnagram(String a, String b) {
        // Write your code here
        // crear arreglo longitud 26
        // encontrar la frecuencia de cada letra

        int [] arrayA = new int[26];
        int [] arrayB = new int[26];

        for (int i = 0; i < a.length(); i++) {
            int current_char = a.charAt(i);
            int pos = current_char - 'a';
//            System.out.println(a.charAt(i)+" : "+current_char+ " pos: " +pos);
            arrayA[pos]++;
        }

        for (int i = 0; i < b.length(); i++) {
            int current_char = b.charAt(i);
            int pos = current_char - 'a';
//            System.out.println(b.charAt(i)+" : "+current_char+ " pos: " +pos);
            arrayB[pos]++;
        }

        int totalDeletions =0;
        for (int i = 0; i < arrayA.length; i++) {
            int deletions = Math.abs(arrayA[i] - arrayB[i]);
            totalDeletions += deletions;
        }

//            System.out.println(Arrays.toString(arrayA));
//        System.out.println(totalDeletions);

        return totalDeletions;
    }
}

// a 97
// e 101
// 101 - 97 = 4
