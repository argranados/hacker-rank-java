package com.ciberaccion.ipk.search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parlor {

    public static void main(String[] args) {
        List<Integer> cost = new ArrayList<>(){{add(2);add(1);add(3);add(5);add(6);}};
        int money = 5;
        Result1.whatFlavors(cost, money);
    }
}

class Result1 {

    /*
     * Complete the 'whatFlavors' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY cost
     *  2. INTEGER money
     */

    public static void whatFlavors(List<Integer> cost, int money) {
        // Write your code here
        int first=0;
        int second=0;
        System.out.println(cost);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < cost.size(); i++) {
            if (map.containsKey(money - cost.get(i))){
                first = i;
//                System.out.println(cost.get(i));
//                System.out.println(money - cost.get(i));
                second = map.get(money - cost.get(i));
            }

            if (!map.containsKey(cost.get(i))) {
                //key= cost,  value=i
                map.put(cost.get(i), i);
            }
        }
        System.out.println(first+" "+second);

    }

}
//https://www.youtube.com/watch?v=7f7aKBRFl9U