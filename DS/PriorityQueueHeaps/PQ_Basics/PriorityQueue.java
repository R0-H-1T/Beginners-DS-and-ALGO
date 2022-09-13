package com.DSA.DS.PriorityQueueHeaps.PQ_Basics;

//Priority Queue are of two types - Min, Max:
//Min Ex:
// 10 2  6  7  8        ~ are the priorities of the p1, p2, p3, p4, p5
// p1 p2 p3 p4 p5
//output - p2 p3 p4 p5 p1


// many ways of implementing this, however one approach is :
// using a heap: CBT(complete binary tree), heap ordering property

// in CBT, note that the elements  should start filling from the left.
// if the tree has no element on its leftmost side, it is not considered to be a CBT

//Using array to store in CBT
// ith index (left child => 2*i + 1, right child => 2*i + 2) and to find the parent of the child use (i-1)/2

//Types of heap
//Min heap = its children should be greater than the root (at every level)
//max heap = its children should be smaller than the root (at every level)

import java.util.ArrayList;

public class PriorityQueue<T> {
    //functions to implement =>  -------- [ FOR Min Heap]
        // 1. isEmpty()
        // 2. size()
        // 3. getMin()
        // 4. removeMin()
        // 5. insert()
    ArrayList<Element<T>> heap;
    public PriorityQueue() {
        heap = new ArrayList<>();
    }
    public boolean isEmpty() {
        return heap.isEmpty();
    }
    public int size() {
        return heap.size();
    }
    public void insert(T data, int priority) {
        Element<T> x = new Element<T>(data, priority);
        heap.add(x);
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1)/2;
        while (childIndex > 0){
            if(heap.get(childIndex).priority < heap.get(parentIndex).priority) {
                Element<T> temp = heap.get(parentIndex);
                heap.set(parentIndex, heap.get(childIndex));
                heap.set(childIndex, temp);
            } else {
                return;
            }
            childIndex = parentIndex;
            parentIndex = (childIndex - 1)/2;
        }
    }
    public T getMin() throws PriorityQueueEmptyException{
        if(heap.isEmpty()) throw new PriorityQueueEmptyException();
        return heap.get(0).data;
    }
    public T removeMin() throws PriorityQueueEmptyException{
        if(heap.isEmpty()) throw new PriorityQueueEmptyException();
        Element<T> ans = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int parentIndex = 0;
        int leftChild = 2*parentIndex+1, rightChild = 2*parentIndex+2;


        while(leftChild < heap.size()) { //leftChild is the index of the leftmost child in the tree && is compared to the size
            int minIndex = parentIndex;     // of the array (if greater, then the loop will stop.)
            if(heap.get(parentIndex).priority > heap.get(leftChild).priority) {
                minIndex = leftChild;
            }
            if(rightChild < heap.size() && heap.get(parentIndex).priority > heap.get(rightChild).priority) {
                minIndex = rightChild;
            }
            if(minIndex == parentIndex) break;
            Element<T> temp = heap.get(parentIndex);
            heap.set(parentIndex, heap.get(minIndex));
            heap.set(minIndex, temp);
            parentIndex = minIndex;
            leftChild = 2*parentIndex + 1;
            rightChild = 2*parentIndex + 1;
        }

        return ans.data;
    }

}

//--------------------- data and its priority ---------------->
class Element<T> {
    T data;
    int priority;
    public Element(T data, int priority) {
        this.data = data;
        this.priority = priority;
    }
}
