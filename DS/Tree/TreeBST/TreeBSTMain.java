package com.DSA.DS.Tree.TreeBST;

import com.DSA.DS.Tree.TreeInitial.TreeMain;
import com.DSA.DS.Tree.TreeInitial.TreeNode;

public class TreeBSTMain {
    public static boolean binarySearch(TreeNode<Integer> root, int n){
        if(root == null) return false;
        if(n == root.data) return true;
        return (n < root.data) ? binarySearch(root.left, n) : binarySearch(root.right, n);
    }
    public static void printInRange(TreeNode<Integer> root, int n1, int n2){
        if(root == null) return;
        if(root.data < n1) printInRange(root.right, n1, n2);
        else if(root.data > n2) printInRange(root.left, n1, n2);
        else {
            System.out.print(root.data+" ");
            printInRange(root.left, n1, n2);
            printInRange(root.right, n1, n2);
        }
    }
    public static void main(String[] args){
        TreeMain t = new TreeMain();
        TreeNode<Integer> root = t.treeInput(true, 0, true);
        t.printTreeNodes(root);
        //System.out.println(binarySearch(root, 4));
        printInRange(root, 2, 6);
    }

}
