package com.ciberaccion.globant.datastructures.search;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'missingNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY brr
     */

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> maparr = new TreeMap<>();
        Map<Integer, Integer> mapbrr = new TreeMap<>();
        int value; int key =0;

        for (int i = 0; i < arr.size(); i++) {
            maparr.put(arr.get(i), 0);
        }
        for (int i = 0; i < brr.size(); i++) {
            mapbrr.put(brr.get(i), 0);
        }

        for (int i = 0; i < brr.size(); i++) {
            key = brr.get(i);
            value = mapbrr.get(key);
            mapbrr.replace(brr.get(i), ++value);
        }

        for (int i = 0; i < arr.size(); i++) {
            key = arr.get(i);
            value = maparr.get(key);
            maparr.replace(arr.get(i), ++value);
        }

        for (int i: mapbrr.keySet()) {
            int valA = maparr.getOrDefault(i,0);
            int valB = mapbrr.getOrDefault(i,0);
            System.out.println(valA+" - "+valB);
            if(valA != valB)
                result.add(i);
        }

        return result;
    }

    public static List<Integer> missingNumbersX(List<Integer> arr, List<Integer> brr) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        List<Integer> result = new ArrayList<>();
        int key; int value;  int freq;

        for (int i: brr) {
            key = i;
            freq = map.getOrDefault(i,0);
            freq++;
            map.put(key, freq);
        }

        for (int i: arr) {
            key = i;
            freq = map.getOrDefault(i,0);
            freq--;
            map.put(key, freq);
        }

        for (int i: map.keySet()) {
            if (map.get(i) > 0 )
                result.add(i);
        }

        return result;
    }

    public static List<Integer> missingNumbers1(List<Integer> arr, List<Integer> brr) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();

        int index=0; int value; int key =0;
        for (int i = 0; i < brr.size(); i++) {
            map.put(brr.get(i), 0);
        }
        while(index < brr.size()){
            if(arr.contains(brr.get(index))) {
                System.out.println("contains " + brr.get(index));
                key = brr.get(index);
                value = map.get(key);
                map.replace(brr.get(index), ++value);
            }
            else
                System.out.println("NO contains "+brr.get(index));
//            if(brr.get(index) != null)
//                System.out.println(arr.get(index));
            index++;
        }
        return result;
    }

}

public class MissingNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/com/ciberaccion/globant/datastructures/search/archivo"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.missingNumbers(arr, brr);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
