package com.ciberaccion.ipk.search;

import com.ciberaccion.ipk.util.Tool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SwapNodes {

    public static void main(String[] args) {
        int [] arr = {1, 5, 3, 4, 2};
        List<Integer> list = Tool.arrayToListConversion(arr);
        Collections.sort(list);
        System.out.println(list);
        int r = Result.pairs(2,list);
        System.out.println(r);
    }
}

class Result {

    /*
     * Complete the 'pairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY arr
     */

    public static int pairs(int k, List<Integer> arr) {
        // Write your code here
        int count =0;
        for (int i = 0; i < arr.size()-1; i++) {
            for (int j = i; j < arr.size(); j++) {
                int dif = Math.abs(arr.get(i) - arr.get(j));
                System.out.println(arr.get(j) + " - " +arr.get(i)+" = "+dif);
                if ( dif == 2 ){
                    count++;
                }
            }
        }
    return count;
    }

}
