package com.DSA.DS.Queue;

import java.util.Queue;

public class QueueArray {
    private int arr[], size, front, rear;
    public QueueArray(){
        arr = new int[5];
        front = rear = -1;
        size = 0;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return size;
    }
    public int front() throws QueueException{
        if(size == 0){
            throw new QueueException();
        }
        return arr[front];
    }
    public void enqueue(int n) throws QueueException{
        if(size == arr.length){
            throw new QueueException();
        }
        if(size == 0) front++;
        rear++;
        if(rear == arr.length) rear = 0;
        arr[rear] = n;
        size++;
    }
    public int dequeue() throws QueueException{
        if(size == 0){
            rear = front = -1;
            throw new QueueException();
        }
        if(front == arr.length) front = 0;
        size--;
        return arr[front++];
    }
    public static void main(String[] args) {

    }
}
