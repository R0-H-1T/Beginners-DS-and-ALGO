package com.DSA.DS.Tree.TreeInitial;

import com.sun.source.tree.Tree;

import java.util.Scanner;

public class TreeMain {

    public static TreeNode<Integer> treeInput(boolean isRoot, int parent_data, boolean isLeft){
        if(isRoot) System.out.println("Enter the data of the root: ");
        else if(isLeft) System.out.println("Enter the data for the left node of "+parent_data+": ");
        else System.out.println("Enter the data for the right node of "+parent_data+": ");

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        if(x == -1) return null;

        TreeNode<Integer> newNode = new TreeNode<>(x);

        TreeNode<Integer> left = treeInput(false, newNode.data, true);
        TreeNode<Integer> right = treeInput(false, newNode.data, false);

        newNode.left = left;
        newNode.right = right;

        return newNode;
    }

    public static void printTreeNodes(TreeNode<Integer> root){
        if(root == null) return;
        System.out.print(root.data+": ");
        if(root.left == null && root.right == null) System.out.print("null");
        if(root.left != null) System.out.print("L"+root.left.data+" ");
        if(root.right != null) System.out.print("R"+root.right.data);
        System.out.println();
        printTreeNodes(root.left);
        printTreeNodes(root.right);
    }
    public static void main(String[] args) {

        //TreePractice t1 = new TreePractice();
        //TreeNode<Integer> root = treeInput(true, 0, true);
        //System.out.println(t1.numberOfNodes(root));
        //printTreeNodes(root);

        TreePractice t2 = new TreePractice();
        TreeNode<Integer> root = treeInput(true, 0, true);
        //--------------------HEIGHT OF TREE ---------------------------------
        //System.out.println(t2.heightOfTree(root));

        //------------------LEAF NODES IN TREE -----------------------------
        //System.out.println(t2.NumberOfLeafNodes(root));

        //------------------ DEPTH k ------------------------------------
//        Scanner sc = new Scanner(System.in);
//        printTreeNodes(root);
//        System.out.println("Print nodes at what depth?: ");
//        t2.depthK(root, sc.nextInt());

        //-------------------BALANCED TREE -------------------------
        //printTreeNodes(root);
        //System.out.println(t2.isBalancedTreeOptimized(root).isBal); //optimizes time complexity
            // O(n);

        //-------------------DIAMETER OF TREE -----------------------------------
        printTreeNodes(root);
        //System.out.println(t2.diameterOfTree(root));
        System.out.println(t2.diameterOfTreeOptimized(root).diameter);
        //---------------TRAVERSALS--------------------
//        System.out.print("Preorder: ");
//        t2.preOrderTraversal(root);
//        System.out.print("\nPostorder: ");
//        t2.postOrderTraversal(root);
//        System.out.print("\nInorder: ");
//        t2.inOrderTraversal(root);
//        System.out.println();
//        System.out.println("Largest node in tree: "+t2.largestNodeInTree(root));

//        TreeNode<Integer> root = new TreeNode<>(2);
//        TreeNode<Integer> n1 = new TreeNode<>(99);
//        TreeNode<Integer> n2 = new TreeNode<>(20);
//        TreeNode<Integer> n3 = new TreeNode<>(12);
//        TreeNode<Integer> n4 = new TreeNode<>(3);
//        root.left = n1;
//        root.right = n2;
//        n1.left = n3;
//        n2.left = n4;

    }
}

