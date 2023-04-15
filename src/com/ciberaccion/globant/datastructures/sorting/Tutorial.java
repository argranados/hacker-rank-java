package com.ciberaccion.globant.datastructures.sorting;

import java.util.ArrayList;
import java.util.List;

public class Tutorial {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(){{add(4); add(3); add(2);}};
        Tutorial.introTutorial(2, list);
    }

    public static int introTutorial(int V, List<Integer> arr) {
        // Write your code here
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(i+ " "+arr.get(i));
            if(arr.get(i) == V)
                return i;
        }
        return 0;
    }
}
