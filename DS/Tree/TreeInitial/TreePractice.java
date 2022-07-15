package com.DSA.DS.Tree.TreeInitial;

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
        System.out.println(root.data);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    public void postOrderTraversal(TreeNode<Integer> root){
        if(root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.data);
    }
    public void inOrderTraversal(TreeNode<Integer> root){
        if(root == null) return;
        inOrderTraversal(root.left);
        System.out.println(root.data);
        inOrderTraversal(root.right);
    }
}