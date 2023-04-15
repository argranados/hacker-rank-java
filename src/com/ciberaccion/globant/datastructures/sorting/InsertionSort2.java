package com.ciberaccion.globant.datastructures.sorting;

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

class Result2 {

    /*
     * Complete the 'insertionSort2' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort2(int n, List<Integer> arr) {
        // Write your code here

        // iterate array,
        // for each element do the InsertionSort1 plus one more element in each iteration
        // join sorted array and unsorted array
        // print array

        int len = arr.size();
        List<Integer> orderedArr = new ArrayList<>();
        List<Integer> array = new ArrayList<>();

        orderedArr.add(arr.get(0));

        for (int i = 1; i < len; i++) {
            orderedArr.add(arr.get(i));
            orderedArr = insertionSort1(orderedArr);

            array.addAll(orderedArr);
            array.addAll(arr.subList(i+1, len));

            for (int elem:array) {
                System.out.print(elem+" ");
            }
            System.out.println();
            array.clear();
        }

    }

    public static List<Integer> insertionSort1(List<Integer> arr) {
        int insertVal = arr.get(arr.size()-1);
        int indexStart = arr.size()-1;
        int i = indexStart;

        //itera para encontrar posicion e imprime
        while(i > -1){
            //Test Case INSERT al inicio
            if(i==0 && insertVal < arr.get(i)) {
                arr.set(i, insertVal);
                break;
            }
            //Test Case INSERT en MEDIO
            if(insertVal < arr.get(i-1))
                arr.set(i, arr.get(i-1));
            if (insertVal > arr.get(i-1)) {
                arr.set(i, insertVal);
                break;
            }
            if (insertVal == arr.get(i)) {
                i--;
                continue;
            }
            i--;
        }
        return arr;
    }

}

public class InsertionSort2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result2.insertionSort2(n, arr);

        bufferedReader.close();
    }
}

