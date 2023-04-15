package com.ciberaccion.globant.datastructures.linkedlist;

public class Practice {

    public static void main(String[] args) {
        NodeList nodeList = new NodeList();

//        nodeList.head = Practice.insertHead(nodeList.head, 4);
//        Practice.printList(nodeList.head);
//        nodeList.head = Practice.insertHead(nodeList.head, 3);
//        Practice.printList(nodeList.head);
//        nodeList.head = Practice.insertHead(nodeList.head, 2);
//        Practice.printList(nodeList.head);
          nodeList.head = Practice.insertTail(nodeList.head, 2);
          Practice.printList(nodeList.head);
          nodeList.head = Practice.insertTail(nodeList.head, 3);
          Practice.printList(nodeList.head);
          nodeList.head = Practice.insertTail(nodeList.head, 4);
          Practice.printList(nodeList.head);
//          nodeList.head = Practice.insertPos(nodeList.head, 35, 3);
//          nodeList.head = deleteHead(nodeList.head);
//          Practice.printList(nodeList.head);
//          nodeList.head = deleteTail(nodeList.head);
//          Practice.printList(nodeList.head);
        nodeList.head = deletePos(nodeList.head,2);
        Practice.printList(nodeList.head);
    }

    public static Node insertTail(Node head, int data){
        Node insertNode = new Node(data);

        if(head == null){
            insertNode.next = null;
            insertNode.prev = null;
            return insertNode;
        }

        Node current = head;
        while(current.next != null){
            current = current.next;
        }

        current.next = insertNode;
        insertNode.prev = current;
        insertNode.next = null;

        return head;
    }

    public static Node insertHead(Node head,int data){
        if(head == null){
            Node insertNode = new Node(data);
            insertNode.next = null;
            insertNode.prev = null;
            return insertNode;
        }

        Node insertNode = new Node(data);
        head.prev = insertNode;
        insertNode.next = head;
        insertNode.prev = null;
        return insertNode;
    }

    public static Node insertPos(Node head, int data, int pos){
        Node insertNode = new Node(data);
        Node prevNode;
        Node current = head;
        int index = 0;
        if(head == null) return head;

        prevNode = null;
        while(current != null){
            index++;
            System.out.println("pos: "+index +"  value:"+current.data);
            if(pos == index) {
                System.out.println("insert here");
                insertNode.prev = prevNode;
                insertNode.next = current;
                prevNode.next = insertNode;
            }
            prevNode = current;
            current = current.next;
        }
        return head;
    }

    public static Node deleteHead(Node head){
        Node newHead = head.next;
        head.next = null;
        newHead.prev = null;

        return newHead;
    }

    public static Node deleteTail(Node head){
        Node current = head;
        Node prev = null;

        while(current.next != null){
            prev = current;
            current = current.next;
        }

        prev.next = null;

        return head;
    }

    public static Node deletePos(Node head, int pos){
        int index =0;
        Node current = head;
        Node prev = null;

        while(pos != index && current.next != null){
            index++;
            prev = current.prev;
            if(pos == index) {
                System.out.println("delete here "+index);
                prev.next = current.next;
                current.prev = prev.next;
            }
            current = current.next;
        }

        return head;
    }

    public static void printList(Node head){
        if(head == null) return;
        System.out.println("-----------------------------------------------");

        while(head != null){                    //CHECAR OBJECTO
            System.out.println(head.data);
            head = head.next;                   //AVANZAR
        }
    }
}

class Node {
    int data;
    int pos;
    Node next;
    Node prev;

    public Node(int data){
        this.data = data;
    }
}

class NodeList {
    Node head;
    Node tail;
    int size;
}