package com.DSA.DS.Queue;

class Node {
    int data;
    Node next;
    Node(int n){
        this.data = n;
        next = null;
    }
}

public class QueueLinkedList {
    private Node front, rear;
    private int size;
    public QueueLinkedList(){
        size = 0;
    }

    public int size(){
        return size;
    }
    public void enqueue(int n){
        Node temp = new Node(n);
        if(front == null) front = rear = temp;
        else{
            rear.next = temp;
            rear = temp;
            size++;
        }

    }
    public int dequeue() throws QueueException{
        if(size == 0) throw new QueueException();
        size--;
        int n = front.data;
        front = front.next;
        return n;
    }
    public int front(){
        return front.data;
    }

}
