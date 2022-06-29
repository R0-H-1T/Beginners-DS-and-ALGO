package com.DSA.DS.LinkedList;

import java.util.Scanner;

public class LinkedListPractice extends LinkedList1{

    // LINKED LIST RECURSION ----------------------------------------------------------------------------------------------------

    // 1. print LL using recursion
    public static void recur_printLL(Node head){
        if(head==null) return;
        System.out.print(head.data+" ");
        recur_printLL(head.next);
    }

    // 2. delete node using recursion
    public static Node recur_deleteAtPos(Node head, int pos){
        if(head == null) return head;
        if(pos == 1) return head.next;

        Node Rhead = recur_deleteAtPos(head.next, pos-1);
        head.next = Rhead;

        return head;
        /*  if pos = 3
            [1, 2, 3, 4, 5]
            1st call checks if pos == 1(4) => no, calls itself(head.next,pos-1[2])
            [2, 3, 4, 5]
            2nd call checks if pos == 1(2) => no, calls itself(head.next),pos-1[1])
            [3, 4, 5]
            3rd call checks if pos == 1(1) => yes, return head.next @of_next_node to Rhead;

        */
    }

    // 3. reverse a LL recursion.
    public  static Node recur_reverseLL(Node head){
        if(head == null || head.next ==null) return head;
        Node nhead = recur_reverseLL(head.next);
        Node temp = nhead;
        while(nhead.next != null){
            nhead = nhead.next;
        }
        nhead.next = head;
        head.next = null;
        return temp;

        /*
            //optimized time complexity
            if(head == null || head.next ==null) return head;
            Node nhead = recur_reverseLL(head.next);
            Node tail = head.next;
            tail.next = head;
            head.next = null;

            return nhead;
         */
    }

    // 4. Merge sort
    public static Node mergeSort(Node head){
        if(head == null || head.next == null) return head;
        Node mid = findMid(head);
        Node first = head;
        Node second = mid.next;
        mid.next = null;

        Node x = mergeSort(first);
        Node y = mergeSort(second);

        Node merged = mergeSortedLL(x, y);

        return merged;
    }












    // LINKED LIST RECURSION END ----------------------------------------------------------------------------------------------------

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
        /* MERGE SORTED LLL ---------------------------------------------------
        /*Scanner sc = new Scanner(System.in);
        System.out.print("Head1:  "); Node head1 = createList(sc.nextInt());
        System.out.print("Head2:  "); Node head2 = createList(sc.nextInt());
        System.out.println("\nmerged and sorted");
        Node sorted = mergeSortedLL(head1, head2);
        System.out.println();
        printNodes(sorted);
        --------------------------------------------------------------------- */

        /* RECUR PRINT NODES
        Node list1 = createList(4);
        recur_printLL(list1);
        -------------------------------------------------------------------- */

        /* RECUR DELETE NODE AT POS
        Node list1 = createList(5);
        printNodes(list1);
        System.out.println();
        printNodes(recur_deleteAtPos(list1, 5));
        ----------------------------------------------------------------------*/

        /* RECUR REVERSE LL
        Node list1 = createList(5);
        printNodes(list1);
        System.out.println();
        list1 = recur_reverseLL(list1);
        printNodes(list1);
        ----------------------------------------------------------------------*/

        /* MERGE SORT ON LL */
        Node list1 = createList(1);
        printNodes(list1);
        list1 = mergeSort(list1);
        System.out.println();
        printNodes(list1);
    }
}
