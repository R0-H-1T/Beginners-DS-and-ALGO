package com.DSA.DS.PriorityQueueHeaps.PQ_Basics;

public class PriorityQueueMain {
    public static void main(String[] args) throws PriorityQueueEmptyException {
        PriorityQueue<String> pq = new PriorityQueue<>();
        pq.insert("p1", 10);
        pq.insert("p2", 8);
        pq.insert("p3", 12);

       while(!pq.isEmpty()) {
           System.out.print(pq.removeMin() + " ");
       }
    }
}
