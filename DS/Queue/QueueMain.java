package com.DSA.DS.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueMain {
    public static void main(String[] args) throws QueueException {
       Queue<Integer> q1 = new LinkedList<>();
       q1.add(34);
       q1.add(5);
       q1.add(89);
       q1.add(99);
        System.out.println(q1.toArray());
        System.out.println(q1.peek());

       QueuePractice pract = new QueuePractice();
       pract.reverseQueue(q1);
        System.out.println(q1.peek());
        System.out.println(q1.toArray());

    }
}
