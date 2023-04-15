package com.ciberaccion.ipk.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BubbleSort {
    public static void main(String[] args) {
        List<Integer> lista= new ArrayList(){{add(3); add(2); add(1);}};
        BubbleSort.countSwaps(lista);
    }

    public static void countSwaps(List<Integer> lista) {
        // Write your code here
        int swaps=0;

        int [] arreglo = convertListToArray(lista);
        swaps = bubbleSort(arreglo);

        System.out.println("Array is sorted in "+ swaps +" swaps");
        System.out.println("First Element: "+ arreglo[0]);
        System.out.println("Last Element: "+ arreglo[arreglo.length-1]);

    }

    public static int bubbleSort(int [] a){
        int swap=0;
        int n = a.length;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    swap++;
                }
            }

        }
    return swap;
    }

    public static void swap(int[] arr, int start, int fin){
        int temp = arr[fin];
        arr[fin] = arr[start];
        arr[start] = temp;
    }

    private static int[] convertListToArray(List<Integer> list){
        int[] array = new int[list.size()];
        for(int i = 0; i < list.size(); i++) array[i] = list.get(i);

        return array;
    }

    private static List<Integer> convertArrayToList(int[] arr){

        return Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList());
    }
}
