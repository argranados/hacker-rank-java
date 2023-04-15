package com.ciberaccion.ipk.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LuckBalance {

    public static void main(String[] args) {
        int canLose=2;  //k
        // {luck, importance}
        int[][] contests = {{5, 1}, {4, 0}, {6, 1}, {2, 1}, {8, 0}};
        List<List<Integer>> list = arrayToListConversion(contests);
        System.out.println(Result3.luckBalance(canLose, list));;
    }

    public static List<List<Integer>> arrayToListConversion(int[][] arr){
        List<List<Integer>> list = Arrays.stream(arr)
                .map(//Stream all the elements of each 1d array and put them into a list of Integer.
                        internalArray -> Arrays.stream(internalArray).boxed().collect(Collectors.toList()))
                .collect(Collectors.toList());
        return list;
    }
}

class Result3 {

    /*
     * Complete the 'luckBalance' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. 2D_INTEGER_ARRAY contests
     */

    public static int luckBalance(int k, List<List<Integer>> contests) {
        // Write your code here
        int luck_balance =0;
        System.out.println(contests);

        Collections.sort(contests, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return -1 * o1.get(0).compareTo(o2.get(0));
            }
        });

        System.out.println(contests);

        for (List<Integer> subList:contests) {
            int luck = subList.get(0);
            int imp = subList.get(1);
            if (imp == 1 && k > 0){
                k--;
                luck_balance += luck;
            } else if (imp == 1 && k == 0){
                luck_balance -= luck;
            }
            if (imp == 0){
                luck_balance += luck;
            }
        }
        return luck_balance;
    }

}
