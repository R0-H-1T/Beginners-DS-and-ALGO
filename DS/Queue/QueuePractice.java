package com.DSA.DS.Queue;

import java.util.*;

class StackUsingTwoQueues {
    Queue<Integer> q1;
    Queue<Integer> q2;
    public StackUsingTwoQueues(){
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    public void push(int n){
        q1.add(n);
    }
    public int pop(){
        while(q1.size() > 1){
            q2.add(q1.poll());
        }
        int x = q1.poll(); //poll -> gives null if nothing in the queue
        //while remove() gives error
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return x;
    }
    public int peek(){
        while(q1.size() > 1){
            q2.add(q1.poll());
        }
        int x = q1.peek();
        //q2.add(q1.poll())
        //Queue<Integer> temp = q1;
        //q1 = q2;
        //q2 = temp;
        while(!q2.isEmpty()){
            q1.add(q2.poll());
        }
        return x;
    }
    public boolean isEmpty(){
        return q1.size() == 0;
    }

}


class QueueUsingTwoStacks {
    // QUEUE USING 2 STACKS
    Stack<Integer> s1;
    Stack<Integer> s2;
    public QueueUsingTwoStacks(){
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    public int size(){
        return s1.size();
    }
    public boolean isEmpty(){
        return s1.isEmpty();
    }
    public void enqueue(int n){
        s1.push(n);
    }
    public int dequeue(){

        while(s1.size() > 1){
            s2.push(s1.pop());
        }
        int x = s1.pop();
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return x;
    }
    public int front(){
        while(!isEmpty()){
            s2.push(s1.pop());
        }
        int x = s2.peek();
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return x;
    }
}

public class QueuePractice {
    public void queueUsingStacks(){
        QueueUsingTwoStacks q4 = new QueueUsingTwoStacks();
        q4.enqueue(34);
        q4.enqueue(56);
        q4.enqueue(44);
        q4.enqueue(11);
        q4.enqueue(9);
        System.out.println(q4.size());
        System.out.println(q4.front());
        System.out.println(q4.dequeue());
        System.out.println(q4.front());
        System.out.println(q4.size());
        System.out.println(q4.dequeue());
        System.out.println(q4.dequeue());
        q4.enqueue(23);
        System.out.println(q4.size());
    }

    public void stackUsingQueues() {
        StackUsingTwoQueues s1 = new StackUsingTwoQueues();
        s1.push(45);
        s1.push(66);
        System.out.println(s1.peek());
        s1.pop();
        s1.push(21);
        System.out.println(s1.peek());

    }

    public static void main(String[] args) {
        QueuePractice main = new QueuePractice();
        System.out.println("Stack using two queue");

        main.stackUsingQueues();
        System.out.println("Queue Using two stack");
        main.queueUsingStacks();
    }
}
