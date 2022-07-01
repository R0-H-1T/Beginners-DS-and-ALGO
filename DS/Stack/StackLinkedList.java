package com.DSA.DS.Stack;


class Node {
    int data;
    Node next;
    public Node(int n){
        this.data = n;
    }
}


public class StackLinkedList {
    private Node head = null;
    private int size = 0;
    public StackLinkedList(){
        head = null;
        size = 0;
    }
    public void push(int n){
        Node newNode = new Node(n);
        newNode.next = head;
        head = newNode;
        size++;
    }
    public int pop() throws StackException{
        if(head == null) throw new StackException();
        int n = head.data;
        head = head.next;
        size--;
        return n;
    }
    public boolean isEmpty(){
        return head == null;
    }
    public int peek() throws StackException{
        if(head == null) throw new StackException();
        return head.data;
    }
    public int sizeLL(){
        return size;
    }
}

