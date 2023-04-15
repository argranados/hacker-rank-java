package com.ciberaccion.globant.datastructures.linkedlist;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ReverseDobleLL {

    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
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
         * Complete the 'reverse' function below.
         *
         * The function is expected to return an INTEGER_DOUBLY_LINKED_LIST.
         * The function accepts INTEGER_DOUBLY_LINKED_LIST llist as parameter.
         */

        /*
         * For your reference:
         *
         * DoublyLinkedListNode {
         *     int data;
         *     DoublyLinkedListNode next;
         *     DoublyLinkedListNode prev;
         * }
         *
         */

        public static DoublyLinkedListNode reverse(DoublyLinkedListNode llist) {
            DoublyLinkedListNode current = llist;
            DoublyLinkedListNode prevNode;
            DoublyLinkedListNode nextNode;
            DoublyLinkedListNode new_head = llist;

            while(current != null){
                nextNode = current.next;
                prevNode = current.prev;
                current.next = prevNode;
                current.prev = nextNode;
                new_head = current;
                current = nextNode;
            }

            while(new_head != null){
                System.out.println(new_head.data);
                new_head = new_head.next;
            }

            return new_head;
        }

    public static DoublyLinkedListNode reverseTwo(DoublyLinkedListNode llist) {
        DoublyLinkedList newList = new DoublyLinkedList();
        DoublyLinkedListNode current = llist;
        TreeMap<Integer,DoublyLinkedListNode> map = new TreeMap<>(Collections.reverseOrder());

        int i =1;

        while(current != null){
            map.put(i++, current);
            current = current.next;
        }

        for (DoublyLinkedListNode node: map.values()) {
            System.out.println("node " +node.data);
            newList.insertNode(node.data);
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
            DoublyLinkedList llist = new DoublyLinkedList();

            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }

            DoublyLinkedListNode llist1 = reverse(llist.head);

            printDoublyLinkedList(llist1, " ", bufferedWriter);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

