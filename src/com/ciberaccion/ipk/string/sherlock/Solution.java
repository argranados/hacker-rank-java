package com.ciberaccion.ipk.string.sherlock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        String string = "aac";
        String result = Result.isValid(string);
        System.out.println(result);
    }
}

class Result {

     public static String isValid(String s) {
        // Write your code here
         HashMap<Character,Integer> map = new HashMap<>();
         for (int i = 0; i < s.length(); i++) {
             char c = s.charAt(i);
             if (map.get(c) != null){
                map.put(c, map.get(c) +1);
             } else {
                 map.put(c, 1);
             }
         }

         // I want only values from the map
         ArrayList<Integer> mapValues = new ArrayList<>(map.values());

         // I want min and max from values array
         int min = (int) Collections.min(mapValues);
         int max = (int) Collections.max(mapValues);

         if(min == max)
             return "YES";

         // Cuantos min y cuantos max hay en el arreglo values
         int min_count=0; int max_count=0;
         for (int i = 0; i < mapValues.size(); i++) {
             if(mapValues.get(i) == min)
                 min_count++;
             else if (mapValues.get(i) == max)
                 max_count++;
         }

         return (min_count==1 || (max_count==1 && max==min+1)) ? "YES" : "NO";

    }

}
