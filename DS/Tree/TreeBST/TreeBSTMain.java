package com.DSA.DS.Tree.TreeBST;

import com.DSA.DS.Tree.TreeInitial.TreeMain;
import com.DSA.DS.Tree.TreeInitial.TreeNode;


//Time complexity of BST : O(n) - O(log(n)) height if tree
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
    // convert an array to BST , time complexity O(n)
    public static TreeNode<Integer> sortedArrayInBST(int arr[], int start, int end){
        if(start > end) return null;
        int mid = (start + end)/2;
        TreeNode<Integer> root = new TreeNode<>(arr[mid]);
        root.left = sortedArrayInBST(arr, start, mid-1);
        root.right = sortedArrayInBST(arr, mid+1, end);
        return root;
    }
    public static void main(String[] args){
        TreeMain t = new TreeMain();
        //TreeNode<Integer> root = t.treeInput(true, 0, true);
        //t.printTreeNodes(root);
        //System.out.println(binarySearch(root, 4));
        //printInRange(root, 2, 6);

        //int[] arr = {5, 8, 12, 17, 22, 26};
        //t.printTreeNodes(sortedArrayInBST(arr, 0, arr.length - 1));

        //------------------------------------------LEVEL 1 ---------------------------------------------
        // isBST
//        TreeBST_Practice tbstp = new TreeBST_Practice();
//        TreeNode<Integer> root = t.treeInput(true, 0, true);
//        t.printTreeNodes(root);
//        System.out.println(tbstp.isBST(root));
        boolean surprise = false;
        boolean gift = true;
        System.out.println(!surprise && gift);
    }

}
