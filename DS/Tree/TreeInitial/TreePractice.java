package com.DSA.DS.Tree.TreeInitial;

import com.sun.source.tree.Tree;

public class TreePractice {
    //count number of nodes in the tree
    public int numberOfNodes(TreeNode<Integer> root){
        if(root == null) return 0;
        int leftNodes = numberOfNodes(root.left);
        int rightNodes = numberOfNodes(root.right);
        return leftNodes + rightNodes + 1;
    }
    //TRAVERSALS
    // 1.preorder => root->left->right,
    // 2.postorder => left->right->root,
    // 3.inorder => left->root->right,
    // level-order =>
    public void preOrderTraversal(TreeNode<Integer> root){
        if(root == null) return;
        System.out.print(root.data+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    public void postOrderTraversal(TreeNode<Integer> root){
        if(root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data+" ");
    }
    public void inOrderTraversal(TreeNode<Integer> root){
        if(root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.data+" ");
        inOrderTraversal(root.right);
    }
    public int largestNodeInTree(TreeNode<Integer> root){
        if(root == null) return 0;
        int x = largestNodeInTree(root.left);
        int y = largestNodeInTree(root.right);

        return Math.max(root.data, Math.max(x, y));
    }
    public int heightOfTree(TreeNode<Integer> root){
        if(root == null) return 0;
        return Math.max(heightOfTree(root.left), heightOfTree(root.right)) + 1;
    }
    /*Number of leaf nodes-- */
    //nodes that don't have any children are leaf nodes
    public int NumberOfLeafNodes(TreeNode<Integer> root){
        if( root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        return NumberOfLeafNodes(root.left) + NumberOfLeafNodes(root.right);

    }
    public void depthK(TreeNode<Integer> root, int k){
        if(root == null) return;
        if(k == 0) System.out.println(root.data);

        depthK(root.left, k-1);
        depthK(root.right, k-1);
    }
    //---------------------------------- LEVEL: 2 -----------------------------
    public boolean isBalancedTree(TreeNode<Integer> root){
        if(root == null) return true;
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);
        if(Math.abs(leftHeight - rightHeight) > 1) return false;
        return isBalancedTree(root.left) && isBalancedTree(root.right);
    }
    //better time complexity for balanced tree->
    public TreeBal isBalancedTreeOptimized(TreeNode<Integer> root){
        if(root == null) {
            return new TreeBal(0, true);
        }
        TreeBal leftTree = isBalancedTreeOptimized(root.left);
        TreeBal rightTree = isBalancedTreeOptimized(root.right);
        int leftHeight = leftTree.height;
        int rightHeight = rightTree.height;
        boolean isBalLeft = leftTree.isBal;
        boolean isBalRight = rightTree.isBal;
        int finalHeight = 1 + Math.max(leftHeight, rightHeight);
        boolean isBal = true;
        if(Math.abs(leftHeight - rightHeight) > 1) isBal = false;
        if(!isBalLeft || !isBalRight) isBal = false;
        return new TreeBal(finalHeight, isBal);
    }

    //diameter of a tree - the longest node from right to left
    public int diameterOfTree(TreeNode<Integer> root){
        if(root == null) return 0;
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);
        int diameter = 1 + leftHeight + rightHeight;

        int leftDiameter = diameterOfTree(root.left);
        int rightDiameter = diameterOfTree(root.right);

        return Math.max(diameter, Math.max(leftDiameter, rightDiameter));
    }
    //optimized solution for finding the diameter
    public TreeDiameter diameterOfTreeOptimized(TreeNode<Integer> root){
        if(root == null) return new TreeDiameter(0, 0);
        TreeDiameter tRight = diameterOfTreeOptimized(root.left);
        TreeDiameter tLeft = diameterOfTreeOptimized(root.right);
        int diameter = 1 + tRight.height + tLeft.height;

        int res = Math.max(diameter, Math.max(tRight.diameter, tLeft.diameter));
        return new TreeDiameter(1 + Math.max(tLeft.height, tRight.height), res);
    }
}

class TreeBal {
    int height;
    boolean isBal;
    TreeBal(int h, boolean isBal){
        this.height = h;
        this.isBal = isBal;
    }
}
class TreeDiameter {
    int height, diameter;
    TreeDiameter(int h, int dia){
        height = h;
        diameter = dia;
    }
}