package com.DSA.DS.Tree.TreeBST;

import com.DSA.DS.Tree.TreeInitial.TreeNode;
import com.DSA.DS.Tree.TreeInitial.TreePractice;
import com.sun.source.tree.Tree;

import java.util.Stack;

public class TreeBST_Practice {
    int maxSum = 0, count = 0;
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
    // O(n) solution ->
    public boolean optimizedIsBST(TreeNode<Integer> root, int min, int max){
        if(root == null) return true;
        if(root.data < min && root.data > max) return false;
        boolean leftSubtree = optimizedIsBST(root.left, min, root.data-1);
        boolean rightSubtree = optimizedIsBST(root.right, root.data+1, max);
        return leftSubtree && rightSubtree;
    }
    // pair sum solution
    // next greater elem => rightmost elem of left tree
    public void printPairs(TreeNode<Integer> root, int sum){
        TreePractice t = new TreePractice();
        int n = t.numberOfNodes(root);
        int count = 0;
        Stack<TreeNode<Integer>> in = new Stack<>();
        Stack<TreeNode<Integer>> revin = new Stack<>();
        TreeNode<Integer> temp = root;
        while(temp != null){
            in.add(temp);
            temp = temp.left;
        }
        temp = root;
        while(temp != null){
            revin.add(temp);
            temp = temp.right;
        }
        while(count <= n-1){
            if(in.peek().data + revin.peek().data == sum){
                System.out.println(in.peek().data + " " + revin.peek().data);
                TreeNode<Integer> inPop = in.pop();
                count++;
                temp = inPop.right;
                while(temp != null){
                    in.push(temp);
                    temp = temp.left;
                }
                TreeNode<Integer> revInPop = revin.pop();
                count++;
                temp = revInPop.left;
                while(temp != null){
                    revin.push(temp);
                    temp = temp.right;
                }
            }else if(in.peek().data + revin.peek().data > sum){
                TreeNode<Integer> revInPop = revin.pop();
                count++;
                temp = revInPop.left;
                while(temp != null){
                    revin.push(temp);
                    temp = temp.right;
                }
            }else{
                TreeNode<Integer> inPop = in.pop();
                count++;
                temp = inPop.right;
                while(temp != null){
                    in.push(temp);
                    temp = temp.left;
                }
            }
        }
    }

    //------------------------------------------- LEVEL 2 -----------------------------------------------------
    //BST L21
    /*
    max sum BST - find the max sum of the all nodes of a BST from a binary tree/binary search tree
    SOLUTION 1 ------ O(n^2) approach :(
    => go on each node and check whether it is a BST, if is store it and check against the stored value
    Steps =>
    1. check if the tree is BST
    2. if is, calculate sum and store it
     */
    //SOLUTION 2 ---------
    /*
        min -   returning the min from the left and the right subtree to root, mainly to check
                if tree is binary or not (min if the right subtree)
        max -   storing the
     */
    public BSTReturn maxSumm(TreeNode<Integer> root){
        if(root == null) return new BSTReturn(Integer.MAX_VALUE, Integer.MIN_VALUE, 0 ,true);
        BSTReturn leftSub = maxSumm(root.left);
        BSTReturn rightSub = maxSumm(root.right);
        int max = Math.max(root.data, Math.max(leftSub.max, rightSub.max));
        int min = Math.min(root.data, Math.min(leftSub.min, rightSub.min));
        boolean BSTFull = leftSub.isBST && rightSub.isBST && leftSub.max < root.data && rightSub.min > root.data;
        int finalSum = leftSub.sum + rightSub.sum + root.data;
        if(BSTFull) maxSum = Math.max(maxSum, finalSum);
        return new BSTReturn(min, max, finalSum, BSTFull);
    }

    /*
            Kth smallest element in binary search tree
            1st smallest elem in tree, 4th smallest elem in tree, 9th smallest elem in tree
     */
    public void kthSmallest(TreeNode<Integer> root, int k){
        if(root == null) return;
        kthSmallest(root.left, k);
        count++;
        if(count == k) System.out.println(root.data);
        kthSmallest(root.right, k);
    }

}

class BSTReturn {
    int min, max, sum;
    boolean isBST;

    public BSTReturn (int min, int max, int sum , boolean isBST) {
        this.min = min;
        this.max = max;
        this.sum = sum;
        this.isBST = isBST;
    }
}
