package com.ciberaccion.ipk.hashmaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagram {
    
    public static void main(String[] args) {
        String s = "abba";
        int r = Result3.sherlockAndAnagrams(s);
        System.out.println(r);
    }
}

class Result3 {

    /*
     * Complete the 'sherlockAndAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */
//    String s = "abba";
    public static int sherlockAndAnagrams(String s) {
        // Write your code here
        int anagramPairs=0;
        Map<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            System.out.println("iteracion "+i);
            for (int j = i; j < s.length(); j++) {
                char[] c = s.substring(i, j+1).toCharArray();
                Arrays.sort(c);
                System.out.println(Arrays.toString(c));

                String k = new String(c);
                if (hashMap.containsKey(k)){
                    hashMap.put(k, hashMap.get(k)+1);
                } else {
                    hashMap.put(k,1);
                }
            }
        }

        for (String k : hashMap.keySet()) {
            int v = hashMap.get(k);
            anagramPairs += (v * (v-1)/2); //
        }

        System.out.println(hashMap);
        return anagramPairs;
    }

}

// take two strings and sort them, if they are equal then they are anagrams of each other
// cuantas combinaciones se pueden hacer de cada occurencia
// https://www.youtube.com/watch?v=OJ65r1e0fTc   minute 12