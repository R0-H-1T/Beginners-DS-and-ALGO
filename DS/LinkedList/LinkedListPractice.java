package com.DSA.DS.LinkedList;

import java.util.Scanner;

public class LinkedListPractice extends LinkedList1{
    public static Node  mergeSortedLL(Node head1, Node head2){
        Node temp1 = head1;
        Node temp2 = head2;
        Node head = null;
        Node tail = null;

        if(temp1.data < temp2.data){
            head = tail = temp1;
            temp1 = temp1.next;
        }else{
            head = tail = temp2;
            temp2 = temp2.next;
        }

        while(temp1!=null && temp2!=null){
            if(temp1.data < temp2.data){
                tail.next = temp1;
                tail = temp1;
                temp1 = temp1.next;
            }else{
                tail.next = temp2;
                tail = temp2;
                temp2 = temp2.next;
            }
        }

        if(temp1 == null) tail.next = temp2;
        else if(temp2 == null) tail.next = temp1;

        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Head1:  "); Node head1 = createList(sc.nextInt());
        System.out.print("Head2:  "); Node head2 = createList(sc.nextInt());


        System.out.println("\nmerged and sorted");
        Node sorted = mergeSortedLL(head1, head2);
        System.out.println();
        printNodes(sorted);

    }
}
