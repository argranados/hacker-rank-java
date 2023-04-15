package com.ciberaccion.ipk.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leftRotation {

    static List<Integer> a =  new ArrayList() {{add(1);add(2);add(3);add(4);add(5);}};  //Arrays.asList(1,2,3,4,5);
    static int d = 6;

    public static void main(String[] args) {
        new leftRotation().rotLeft(a,d);
    }

    public List<Integer> rotLeft(List<Integer> a, int d) {
        System.out.println(a);

        int startIndex =0;
        Integer element =0;

        for (int i = 0; i < d; i++) {
            element = a.remove(startIndex);
            a.add(element);
        }

        System.out.println("result -  "+a);

        return a;
    }

}
