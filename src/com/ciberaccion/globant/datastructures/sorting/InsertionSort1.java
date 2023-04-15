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

class Result {

    /*
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort1(int n, List<Integer> arr) {
        // Write your code here
        int insertVal = arr.get(arr.size()-1);
        int indexStart = arr.size()-1;
        int i = indexStart;

//        for (int i = indexStart; i >= 0; i--) {
//            if(insertVal < arr.get(i))
//                arr.set(i + 1, arr.get(i));
//            else
//                arr.set(i+1, insertVal);
//
//            for (int y: arr) {
//                System.out.print(y + " ");
//            }
//            System.out.println();
//        }

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

            for (int x: arr) {
                System.out.print(x+" ");
            }
            System.out.println();
            i--;
        }
        //imprime la lista ordenada
        for (int x: arr) {
            System.out.print(x+" ");
        }
    }

}

public class InsertionSort1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.insertionSort1(n, arr);

        bufferedReader.close();
    }
}

