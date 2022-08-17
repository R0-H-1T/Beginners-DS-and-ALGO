package com.DSA.DS.Tree.TreeBST;

import com.DSA.DS.Tree.TreeInitial.TreeNode;
import com.DSA.DS.Tree.TreeInitial.TreePractice;
import com.sun.source.tree.Tree;

import java.util.Stack;

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
}
