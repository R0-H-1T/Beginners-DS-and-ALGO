package com.DSA.DS.Tree.TreeInitial;

import com.DSA.DS.Array.Array;
import com.sun.source.tree.Tree;

import java.util.*;

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
    public void levelOrderTraversal(TreeNode<Integer> root){
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode<Integer> r = q.remove();
            System.out.print(r.data+" ");
            if(r.left != null) q.add(r.left);
            if(r.right != null) q.add(r.right);
        }
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
    //prints all the nodes at k distance from root node of a tree
    public void depthK(TreeNode<Integer> root, int k){
        if(root == null) return;
        if(k == 0) System.out.print(root.data+" ");

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

    //diameter of a tree - finding the max number of nodes from left to right
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
    //mirroring a tree
    public void mirrorTree(TreeNode<Integer> root){
       if(root == null) return;
       mirrorTree(root.left);
       mirrorTree(root.right);
       TreeNode<Integer> temp = root.left;
       root.left = root.right;
       root.right = temp;
    }

    //----------------------------------- LEVEL 3 ------------------------------------

    // path from root to leaf with a given sum
    // (find out the path from root to leaf whose sum of all the nodes would be equal to sum provided)
    public void sumOfPathFromRootToLeaf(TreeNode<Integer> root, int sum, ArrayList<Integer> arr){
        if(root == null) return;

        arr.add(root.data);
        if(root.left == null && root.right == null){
            sum -= root.data;
            if(sum == 0) {
                for(int i : arr) System.out.print(i+" ");
            }
            arr.remove(arr.size() - 1); //outside if-block
            return;
        }
        sumOfPathFromRootToLeaf(root.left, sum-root.data, arr);
        sumOfPathFromRootToLeaf(root.right, sum-root.data, arr);
        arr.remove(arr.size() - 1);  //arr size will be decremented
    }

    // print nodes at distance k from the given node;
    public int KDistance(TreeNode<Integer> root, int k, TreeNode<Integer> node){
        if(root == null) return -1;
        if(root.data == node.data) {
            depthK(root, k);
            return 0;
        }
        int leftDist = KDistance(root.left, k, node);
        if(leftDist != -1){
            if(leftDist + 1 == k) System.out.print(" "+root.data);
            else depthK(root.right, k-leftDist-2);
            return leftDist + 1;
        }
        int rightDist = KDistance(root.right, k, node);
        if(rightDist != -1){
            if(rightDist + 1 == k) System.out.print(" "+root.data);
            else depthK(root.left, k-rightDist-2);
            return rightDist + 1;
        }
        return -1;
    }

    //print zigzag tree
    /*

     */
    public void printZigZag(TreeNode<Integer> root){
        int counter = 1; //if node count is even
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        Stack<TreeNode<Integer>> s = new Stack<>();
        q.add(root);
        q.add(null);
        while(q.size() > 1) {
            TreeNode<Integer> ele = q.remove();
            if(ele == null){
                if(counter % 2 != 0){
                    while(!s.isEmpty()) System.out.print(s.pop().data+" ");
                    s = new Stack<>();
                }
                counter++;
                q.add(null);
                continue;
            }
            if(counter % 2 != 0) System.out.print(ele.data+" ");
            if(ele.left != null){
                q.add(ele.left);
                if(counter % 2 != 0) s.add(ele.left);
            }
            if(ele.right != null){
                q.add(ele.right);
                if(counter % 2 != 0) s.add(ele.right);
            }
        }
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