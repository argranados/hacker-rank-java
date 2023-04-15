package com.ciberaccion.ipk.greedy;

import java.util.ArrayList;
import java.util.List;

public class Minimum {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(){{add(3);add(-7);add(0);}};
        int r = Result.minimumAbsoluteDifference(list);
        System.out.println(r);
    }
}

class Result {

    /*
     * Complete the 'minimumAbsoluteDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int minimumAbsoluteDifference(List<Integer> arr) {
        // Write your code here
        int min=Integer.MAX_VALUE;
        System.out.println(min);
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i+1; j < arr.size(); j++) {
                int diff = Math.abs(arr.get(i) - arr.get(j));
                if (diff < min)
                    min = diff;
                System.out.println(arr.get(i) +" - "+arr.get(j)+"  "+diff);
            }
        }
        return min;
    }

}
