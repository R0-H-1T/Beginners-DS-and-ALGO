package com.DSA.DS.LinkedList;































/*public class LinkedListPractice {
    public Node rmConsecutiveDuplicates(Node head){
        // [3,3,3,2,2,5,3] => [3,2,5,3]
        Node temp = head;
        Node curNode = head.next;
        if(temp==null) return head;

        while(curNode!=null){

            if(temp.data != curNode.data) {
                temp.next = curNode;
                temp = temp.next;
            }
            curNode = curNode.next;

        }



//        while(p!=null){
//            System.out.print(p.data+" ");
//            p=p.next;
//        }
        return temp;
    }
}
*/