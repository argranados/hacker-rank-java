package com.ciberaccion.globant.datastructures.linkedlist;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RemoveDuplicatesLL {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

//    class Result {

        /*
         * Complete the 'removeDuplicates' function below.
         *
         * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
         * The function accepts INTEGER_SINGLY_LINKED_LIST llist as parameter.
         */

        /*
         * For your reference:
         *
         * SinglyLinkedListNode {
         *     int data;
         *     SinglyLinkedListNode next;
         * }
         *
         */

        public static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode llist) {
            // Write your code here
            SinglyLinkedListNode current;

            current = llist;
            SinglyLinkedListNode next = current.next;

            while(next != null) {
                if (current.data == next.data) {  // data iguales?
                    current.next = next.next;     // entonces brinca nodo y apunta al next
                    next = current.next;        // actualiza next, en caso de mismo valor repetido 3,3,3
                    if (current.next == null)   // hasta que next sea nulo sal del ciclo
                        break;
                    continue;                   // si cambio next NO avances nodos, prueba OTRA VEZ
                }
                current = current.next; //avanza current
                next = current.next;    //avanza next
            }

            return llist;
        }

    public static SinglyLinkedListNode removeDuplicatesTwo(SinglyLinkedListNode llist) {

//        HashMap<Integer,Integer> map = new HashMap<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int i = 1;

        while(llist != null){
            map.put(llist.data, i++);
            llist = llist.next;
        }

        System.out.println(map);

        SinglyLinkedList newList = new SinglyLinkedList();

        TreeSet<Integer> keys = (TreeSet<Integer>) map.keySet();
        for (Integer k :keys) {
          newList.insertNode(k);
        }

        return newList.head;
    }

//    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/com/ciberaccion/globant/datastructures/linkedlist/archivo"));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            SinglyLinkedList llist = new SinglyLinkedList();

            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }

            SinglyLinkedListNode llist1 = removeDuplicatesTwo(llist.head);

            printSinglyLinkedList(llist1, " ", bufferedWriter);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

