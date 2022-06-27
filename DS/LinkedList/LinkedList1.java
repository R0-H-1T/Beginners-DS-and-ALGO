package com.DSA.DS.LinkedList;


import java.util.Scanner;

public class LinkedList1 {

    public static Node createList(int n){
        Scanner sc = new Scanner(System.in);
        Node head = null, tail = null;
        for(int i=0; i<n; i++){
            Node temp = new Node(sc.nextInt());
            if(head == null) {
                head = tail = temp;
            }else{
                tail.next = temp;
                tail = temp;
            }
        }
        return head;
    }

    public static void incrementNode(Node head){
        while(head!=null){
            head.data++;
            head = head.next;
        }
    }

    public static void printNodes(Node head){
        while(head!=null){
            System.out.print(head.data+" ");
            head = head.next;
        }
    }

    public static int len(Node head){
        Node temp = head;
        int count = 0;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static int findMid(Node head){
       /* Node temp = head;
        int count = len(temp);
        if(count>2){
            int i = 0;
            Node n = head;
            while(i<count/2){
                n = n.next; i++;
            }
            return n.data;
        }
        return 0;*/

        Node fast = head;
        Node slow = head;
        while(fast.next != null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.data;
    }

    public static Node insertNode(Node head, int pos){
        Scanner sc = new Scanner(System.in);
        Node temp = head;
        System.out.println("Enter value: ");
        Node newNode = new Node(sc.nextInt());
        if(pos == 1){
            newNode.next = temp;
            head = newNode;
            return head;
        }
        int count = 1;
        while(count<pos-1){
            temp = temp.next;
            count++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }//54:35

    public static Node deleteNode(Node head, int pos){
        Node temp = head;
       if(pos == 1){
            head = head.next;
            return head;
        }

        int count = 1;
        while(count < pos-1){
            temp = temp.next;
            count++;
        }

        temp.next = temp.next.next;

        return head;
    }

    public static Node rmConsecutiveDuplicates(Node head){
        // [3,3,3,2,2,5,3] => [3,2,5,3]
        Node temp = head;
        Node cur = head;
        while(cur!=null){
            while(cur!=null && temp.data== cur.data){
                cur = cur.next;
            }
            temp.next = cur;
            temp = cur;
        }
        return head;
    }


    public static Node reverse(Node head){
        //make three pointers
        // [2,3,4,5]  -> temp=null, curNode=2, nextNode=3;
        //               curNode.next=temp; temp=curNode; curNode=nextNode; nextNode=nextNode.next;
        // curNode is what we are reversing the node from
        Node prev = null;
        Node curNode = head;
        Node nextNode = null;

        while(curNode!=null){
            nextNode = curNode.next;
            curNode.next = prev;
            prev = curNode;
            curNode = nextNode;
        }
        head = prev;

        return head;
    }

}

