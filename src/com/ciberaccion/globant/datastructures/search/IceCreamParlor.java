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

public class IceCreamParlor {

    public static void main(String[] args) {
        int m =4;
        List<Integer> costs = new ArrayList<>(){{add(1); add(4); add(5); add(3);add(2);}};
//        List<Integer> costs = new ArrayList<>(){{add(2); add(2); add(4); add(3);}};
        List<Integer> list = IceCreamParlor.icecreamParlor(m,costs);
        System.out.println(list);
    }

    /*
     * Complete the 'icecreamParlor' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER m
     *  2. INTEGER_ARRAY arr
     */

    public static List<Integer> icecreamParlor(int m, List<Integer> arr) {
        // Write your code here
        List<Integer> resultList = new ArrayList<>();
        int len = arr.size();
        for (int i = 0; i < len ; i++) {
            for (int j = i+1; j < len ; j++) {
                System.out.println(arr.get(i) +" "+arr.get(j) + "= "+(arr.get(i)+arr.get(j)));
                if (arr.get(i) + arr.get(j) == m){
                    resultList.add(i+1);            //add 1 because result is presented based 1 index not 0 index
                    resultList.add(j+1);
                    Collections.sort(resultList);
                    System.out.println(i +" "+j);
            }

            }

        }
        return resultList;
    }

}

