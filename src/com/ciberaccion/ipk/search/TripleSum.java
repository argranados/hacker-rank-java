package com.ciberaccion.ipk.search;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class TripleSum {

    public static void main(String[] args) {
        int[] a = {1,4,5};
        int[] b = {2,3,3};
        int[] c = {1,2,3};
        long result = TripleSum.triplets(a,b,c);
        System.out.println(result);
    }

    // Complete the triplets function below.
    // a < b    b > c
    static long triplets(int[] a, int[] b, int[] c) {
        b = removeDuplicatesTree(b);
//        b = removeDuplicateElementsStream(b,1);
        System.out.println(Arrays.toString(b));
        int counter= 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] <= b[j]){
                    for (int k = 0; k < c.length; k++) {
                        if (b[j] >= c[k]){
                            System.out.println(a[i]+ " " +b[j]+ " " +c[k]);
                            counter++;
                        }
                    }
                }
            }
        }
        return counter;
    }

    static int[] removeDuplicatesTree(int arr[]){

        Set<Integer> tree = new TreeSet<Integer>();
        for (int i = 0; i <arr.length; i++) {
            tree.add(arr[i]);
        }
//        System.out.println(tree);
        int i=0;
        int[] temp = new int[tree.size()];
        for (Integer elemn:tree ) {
            temp[i++] = elemn;
        }
        return temp;
    }

    public static int[] removeDuplicateElementsStream(int arr[], int n){
        int[] temp = java.util.stream.IntStream.of(arr).distinct().toArray();
        return temp;
    }

}

