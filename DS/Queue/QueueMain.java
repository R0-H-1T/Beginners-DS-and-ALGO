package com.DSA.DS.Queue;

import java.util.Queue;

public class QueueMain {
    public static void main(String[] args) throws QueueException {
        QueueLinkedList q1 = new QueueLinkedList();
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
        System.out.println(q1.dequeue());
        System.out.println(q1.dequeue());
        q1.enqueue(23);

    }
}
