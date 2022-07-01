package com.DSA.DS.Stack;

public class StackLinkedListUse {
    public static void main(String[] args) throws StackException {
        StackLinkedList l1 = new StackLinkedList();
        l1.push(23);
        l1.push(-90);
        l1.push(3);
        l1.push(62);
        System.out.println(l1.peek());
        System.out.println(l1.sizeLL());
        System.out.println(l1.pop());
        System.out.println(l1.peek());
        System.out.println(l1.sizeLL());

    }
}
