package com.ciberaccion.ipk.arrays;

public class MinimuSwaps {

    public static void main(String[] args) {
        int arr[] = {7, 1, 3, 2, 4, 5, 6};
//        int arr[] = {4,3,1,2};
        System.out.println("swaps "+MinimuSwaps.minimumSwaps(arr));
    }

    static int minimumSwaps(int[] arr) {
        int swaps =0;

//        while(needSwap(arr)) {
//          swaps++;
//        }

        while(!isPositionCorrect(arr))
            swaps++;
//        if(!isPositionCorrect(arr)) {
//            swaps++;
//        }


        return swaps;
    }

    private static boolean isPositionCorrect(int[] arr) {
        int len = arr.length;
        int start = -1;
        int end=-1;

        for (int i = 0; i < len ; i++) {
            int position = i+1;
            if(arr[i] != position) {
                if(start==-1) {
                    start = i;
                    end = arr[i]-1;
                    break;
                }
            }
        }
        if(start!=-1 && end!=-1) {
            swap(arr, start, end);
            return false;
        }

        return true;
    }

    private static void swap(int[] arr, int start, int fin) {

        int temp = arr[fin];
        arr[fin] = arr[start];
        arr[start] = temp;
    }

    private static boolean needSwap(int[] arr) {
        int len = arr.length;

        for (int i = 0; i < len-1 ; i++) {
            if(arr[i]>arr[i+1]) {
                swap(arr, i, i + 1);
                return true;
            }
        }
        return false;
    }
}
