package com.ciberaccion.ipk.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class NewYearChaos {

    static HashMap<Integer, Integer>jumpMaps = new HashMap<>();
    static boolean chaos;

    public static void main(String[] args) {
//        List<Integer> list = new ArrayList() {{add(2); add(1); add(5); add(3); add(4);}};
//        List<Integer> list = new ArrayList() {{add(5); add(1); add(2); add(3); add(7); add(8); add(6); add(4);}};
        List<Integer> list = new ArrayList() {{add(1); add(2); add(5); add(3); add(7); add(8); add(6); add(4);}}; //1 2 5 3 7 8 6 4
        new NewYearChaos().minimumBribes(list);
    }

    public void minimumBribes(List<Integer> q) { //q = [2, 1, 5, 3, 4]
        // Write your code here
        boolean isEqual=false;
        chaos=false;
        System.out.println(q + "   original");

        List<Integer> sortedList = q.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedList + "   ordenado");

        while(!chaos && !isEqual){
            q = orderListLoop(q);
            System.out.println(q + "   ciclo");
            isEqual = q.equals(sortedList);
        }

        int brincos = jumpMaps.values().stream().mapToInt(d->d).sum();

        if(chaos)
            System.out.println("Too chaotic");
        else
            System.out.println(brincos);


//        q = orderListLoop(q);
//        System.out.println(q);
//        if(chaos)
//            System.out.println("Too caothic");
//
//        isEqual = q.equals(sortedList);
//        System.out.println("Equal "+isEqual);
//
//        if(!isEqual)
//            q = orderListLoop(q);
//
//        System.out.println(q);
//        isEqual = q.equals(sortedList);
//        System.out.println("Equal "+isEqual);

        System.out.println(jumpMaps);
    }

    public static List<Integer> orderListLoop(List<Integer> q){
        int first = 0;
        int second = 0;
        int aLen = q.size();

        for (int i = 0; i < aLen-1; i++) {
            first = q.get(i);
            second = q.get(i+1);
            if (first > second)
                q = swap(q, i, i+1);
        }
        return q;
    }

    public static List<Integer> swap(List<Integer> list, int ini, int fin){
        Integer temp = list.get(ini);
        Integer valueFin = list.get(fin);
        list.set(ini, valueFin);
        list.set(fin, temp);
        countSwaps(temp);

        return list;
    }

    public static Integer countSwaps(Integer element){
        Optional<Integer> jumps = Optional.ofNullable(jumpMaps.get(element));
        int brincos = jumps.orElse(0);
        jumpMaps.put(element, ++brincos );
        if (brincos>2)
            chaos = true;

        return brincos;
    }

}
