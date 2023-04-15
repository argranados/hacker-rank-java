package com.ciberaccion.ipk.greedy;

public class Florist {

    public static void main(String[] args) {
        int k = 3;   //friends
//        int[] price = {2,5,6};
        int[] price = {1,3,5,7,9};
        Florist.getMinimumCost(k,price);
    }

    // Complete the getMinimumCost function below.
    static int getMinimumCost(int k, int[] c) {
        boolean first = true;
        int cost = 0;
        for (int i = c.length-1; i >= 0; i--) {
            if(k !=1 ){
                cost += c[i];
                System.out.println(c[i]);
            } else {
                if(first) {
                    cost += c[i];
                    System.out.println(c[i]);
                    first=false;
                    continue;
                }
                else
                    cost += c[i] * (1+1);
                System.out.println(c[i] * (1+1));
                continue;
            }
            k--;
        }
        System.out.println("cost "+cost);
        return cost;
    }

}


