package com.ciberaccion.ipk.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MarkAndToys {

    public static void main(String[] args) {
//        List<Integer> lista = new ArrayList() {{add(1); add(12);add(5);add(20);}};
        List<Integer> lista = new ArrayList() {{add(1); add(12);add(5);add(111);add(200);add(1000);add(10);}};
        MarkAndToys.maximumToys(lista, 50);
    }

    public static int maximumToys(List<Integer> prices, int k) {
        // Write your code here

        Collections.sort(prices);
        System.out.println(prices);
        int sum=0; int budget = k; int i =0;

        while(i < prices.size()){
            sum += prices.get(i++);
            if ( sum < budget) {
                continue;
            }
            else {
                sum -= prices.get(--i);
                break;
            }
        }
        System.out.println("budget "+budget+" : sum "+sum+ " toys "+i);

        return i;
    }
}
