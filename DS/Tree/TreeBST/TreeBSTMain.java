package com.DSA.DS.Tree.TreeBST;

import com.DSA.DS.Tree.TreeInitial.TreeMain;
import com.DSA.DS.Tree.TreeInitial.TreeNode;

public class TreeBSTMain {
    public static boolean binarySearch(TreeNode<Integer> root, int n){
        if(root == null) return false;
        if(n == root.data) return true;
        return (n < root.data) ? binarySearch(root.left, n) : binarySearch(root.right, n);
    }
    public static void main(String[] args){
        TreeMain t = new TreeMain();
        TreeNode<Integer> root = t.treeInput(true, 0, true);
        t.printTreeNodes(root);
        System.out.println(binarySearch(root, 4));
    }
}
