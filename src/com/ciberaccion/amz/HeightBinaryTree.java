package com.ciberaccion.amz;

public class HeightBinaryTree {
    public static void main(String[] args) {
        Nodo root = new Nodo(3);
        root.left = new Nodo(2);
        root.left.left = new Nodo(1);
        root.right = new Nodo(5);
        root.right.right = new Nodo(6);
        root.right.left = new Nodo(4);
        root.right.right.right = new Nodo(7);

//        Node root = new Node(3);
//        root.left = new Node(1);
//        root.right = new Node(7);
//        root.right.left = new Node(5);
//        root.right.left.left = new Node(4);

        printTree(root, 4);
        System.out.println("deep "+ heightRec(root));
    }

    public static int height(Nodo root) {
        // Write your code here.
//        en el nodo root, obtiene la profundidad de lEFT
        int left = leftDeep(root);
//        en el nodo root, obtiene la profundidad de RIGHT
        int rigth = rigthDeep(root);
        if (left>rigth)
            return left;
        else
            return rigth;
    }

    public static int leftDeep(Nodo nodo){
        int deep=0;
        while(nodo.left != null){
            nodo = nodo.left;
            deep++;
        }
        return deep;
    }

    public static int rigthDeep(Nodo nodo){
        int deep=0;
        while(nodo.right != null){
            nodo = nodo.right;
            deep++;
        }
        return deep;
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

    public static int heightRec(Nodo root){ // Calcula MAL debe ser 3 y da 4

        // the root is null then the height of the tree will be Zero
        if (root == null)
            return -1;
        else
        {
            /* compute  height of each subtree */
            int lheight = heightRec(root.left);
            int rheight = heightRec(root.right);

            /* use the larger one */
            // height of both the sub trees is calcualted and which one is higher is used.
            if (lheight > rheight)
                return(lheight+1);
            else
                return(rheight+1);
        }
    }
}

class Node {
    Nodo left;
    Nodo right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}