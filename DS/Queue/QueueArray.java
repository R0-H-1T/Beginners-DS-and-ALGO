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
    public int front(){
        return arr[front];
    }
    public void enqueue(int n) throws QueueFullException{
        if(size == arr.length){
            throw new QueueFullException();
        }
        if(size == 0) front++;
        arr[++rear] = n;
        size++;
    }
    public int dequeue() throws QueueFullException{
        if(size == 0){
            rear = front = -1;
            throw new QueueFullException();
        }
        size--;
        return arr[front++];
    }
    public static void main(String[] args) {

    }
}