package com.ciberaccion.globant.datastructures.tree;

import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

/* you only have to complete the function given below.
Node is defined as

class Node {
    int data;
    Node left;
    Node right;
}

*/
//    Pre-order tree traversal in 3 minutes
//    https://www.youtube.com/watch?v=1WxLM2hwL-U

    public static void preOrder(Node root) {
        if(root == null)
            return;

        visitNode(root);
        preOrder(root.left);
        preOrder(root.right);

    }

    private static void visitNode(Node root) {
        System.out.print(root.data+" ");
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
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
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        preOrder(root);
    }
}
