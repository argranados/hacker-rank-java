package com.ciberaccion.amz;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        List<Integer> lista = new ArrayList() {{add(12); add(4); add(5); add(3); add(8); add(7);}};
//        Test.testPQ();
//        Test.findMedia(lista);
//        Test.testLogicalOperands();
        Test.mapDuplicates();
    }

    public static void testPQ(){
//        PriorityQueue<Integer> lowers = new PriorityQueue<>();
        PriorityQueue<Integer> lowers = new PriorityQueue<>(Comparator.reverseOrder());

        lowers.add(7);
        lowers.add(9);
        lowers.add(5);

//        System.out.println(lowers);
    }

    public static List<Double> findMedia(List<Integer> lista){
        PriorityQueue<Integer> highers = new PriorityQueue<>();
        PriorityQueue<Integer> lowers = new PriorityQueue<>(Comparator.reverseOrder());
        Double[] medians = new Double[lista.size()];

        for (int i = 0; i < lista.size(); i++) {
            addNumber(lista.get(i), lowers, highers);
            rebalance(lowers, highers);
            medians[i]= getMedians(lowers, highers);

        }

        System.out.println(lowers);
        System.out.println(highers);
        System.out.println(Arrays.toString(medians));

        return Arrays.asList(medians);
    }

    private static double getMedians(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;

         if(biggerHeap.size() == smallerHeap.size()){
            return ( double) (biggerHeap.peek() + smallerHeap.peek()) /2;
         } else {
             return biggerHeap.peek();
         }
    }

    private static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;

        if(biggerHeap.size() - smallerHeap.size() >= 2) {
            smallerHeap.add(biggerHeap.poll());
        }
    }

    private static void addNumber(Integer number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        if(lowers.size() == 0 || number < lowers.peek())
            lowers.add(number);
        else
            highers.add(number);
    }

    private static void testLogicalOperands(){
        System.out.println("OR");
        System.out.println((true || true));
        System.out.println((true || false));
        System.out.println((false || true));
        System.out.println((false || false));

        System.out.println("AND");
        System.out.println((true && true));
        System.out.println((true && false));
        System.out.println((false && true));
        System.out.println((false && false));

    }

    public static void mapDuplicates(){
        HashMap<Integer,String> map = new HashMap<>();

        map.put(1,"a");
        map.put(2,"b");
        map.put(1,"c");

        System.out.println(map);

    }
}
