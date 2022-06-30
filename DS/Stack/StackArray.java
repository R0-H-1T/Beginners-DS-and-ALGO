package com.DSA.DS.Stack;

public class StackArray {
    private int arr[], top;
    public StackArray(){
        arr = new int[5];
        top = -1;
    }
    public void push(int n) throws StackException{
        if(top == arr.length-1) doubleSize();
        arr[++top] = n;
    }
    public int pop() throws StackException{
        if(isEmpty()) throw  new StackException();
        return arr[top--];
    }
    public boolean isEmpty(){
        return top == -1;
    }
    public int size(){
        return top+1;
    }

    public int peek(){
        return arr[top];
    }
    public void doubleSize(){
        int[] temp = arr;
        arr = new int[arr.length+5];
        int i = 0;
        for(int n: temp){
            arr[i++] = n;
        }
    }
}
