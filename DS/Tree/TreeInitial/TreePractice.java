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

}
