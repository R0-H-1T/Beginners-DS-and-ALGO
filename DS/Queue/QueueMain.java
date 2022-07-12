package com.DSA.DS.Queue;

public class QueueMain {
    public static void main(String[] args) throws QueueException {
        QueueArray q1 = new QueueArray();
        System.out.println(q1.isEmpty());
        q1.enqueue(34);
        q1.enqueue(56);
        q1.enqueue(44);
        q1.enqueue(11);
        q1.enqueue(9);
        System.out.println(q1.size());
        System.out.println(q1.front());
        System.out.println(q1.dequeue());
        System.out.println(q1.front());
        System.out.println(q1.size());
        System.out.println(q1.isEmpty());
        System.out.println(q1.dequeue());
        System.out.println(q1.dequeue());
        q1.enqueue(23);

    }
}
