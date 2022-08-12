package com.DSA.DS.Tree.TreeBST;

import com.DSA.DS.Tree.TreeInitial.TreeNode;

public class TreeBST_Practice {
    public int highestNodeInTree(TreeNode<Integer> root){
        if(root == null) return Integer.MIN_VALUE;
        int leftMax = highestNodeInTree(root.left);
        int rightMax = highestNodeInTree(root.right);
        return Math.max(root.data, Math.max(leftMax, rightMax));
    }
    public int lowestNodeInTree(TreeNode<Integer> root){
        if(root == null) return  Integer.MAX_VALUE;
        int leftMin = lowestNodeInTree(root.left);
        int rightMin = lowestNodeInTree(root.right);
        return Math.min(root.data, Math.min(leftMin, rightMin));
    }
    // check if the tree is BST or not
    // if (the max of the left subtree is < root && the min of right subtree is > root)
    public boolean isBST(TreeNode<Integer> root){
        if(root == null) return true;
        int maxLeft = highestNodeInTree(root.left);
        int minRight = lowestNodeInTree(root.right);
        if(maxLeft > root.data && minRight < root.data) return false;
        boolean leftIsBST = isBST(root.left);
        boolean rightIsBST = isBST(root.right);
        return leftIsBST && rightIsBST;
    }
}
