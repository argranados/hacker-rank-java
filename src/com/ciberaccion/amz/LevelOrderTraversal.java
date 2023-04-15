package com.ciberaccion.amz;

import java.util.*;

class Nodo {
    Nodo left;
    Nodo right;
    int data;

    Nodo(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class LevelOrderTraversal {

    public static void levelOrder(Nodo root) {
        System.out.println("level order");
        printTree(root, 5);

        while(root.left != null || root.right !=null){
            System.out.println(root.data);
            if(root.left!=null)
                root = root.left;
            else {
                root = root.right;
            }
        }
    }

    public static Nodo insert(Nodo root, int data) {
        if(root == null) {
            return new Nodo(data);
        } else {
            Nodo cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Nodo root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }

    public static void printTree(Nodo nodo, int height){
        for (int level = 1; level < height+1; level++) {
            printCurrentLevel(nodo, level);
            System.out.println();
        }
    }

    public static void printCurrentLevel(Nodo root, int level){
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1)
        {
            printCurrentLevel(root.left, level-1);
            printCurrentLevel(root.right, level-1);
        }
    }
}
