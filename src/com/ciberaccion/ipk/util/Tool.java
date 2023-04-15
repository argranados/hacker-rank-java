package com.ciberaccion.ipk.util;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Tool {

    public static List<List<Integer>> array2DToListConversion(int[][] arr){
        List<List<Integer>> list = Arrays.stream(arr)
                .map(//Stream all the elements of each 1d array and put them into a list of Integer.
                        internalArray -> Arrays.stream(internalArray).boxed().collect(Collectors.toList()))
                .collect(Collectors.toList());
        return list;
    }

    public static List<Integer> arrayToListConversion(int[] arr){
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        return list;
    }

    static int[] removeDuplicatesTree(int arr[]){
        Set<Integer> tree = new TreeSet<Integer>();
        for (int i = 0; i <arr.length; i++) {
            tree.add(arr[i]);
        }
        int i=0;
        int[] temp = new int[tree.size()];
        for (Integer elemn:tree ) {
            temp[i++] = elemn;
        }
        return temp;
    }

    public static int[] removeDuplicatesStream(int arr[]){
        int[] temp = java.util.stream.IntStream.of(arr).distinct().toArray();
        return temp;
    }
}