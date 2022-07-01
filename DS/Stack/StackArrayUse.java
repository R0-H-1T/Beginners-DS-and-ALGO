package com.DSA.DS.Stack;

import java.util.Stack;

public class StackArrayUse {
    public static void main(String[] args) throws StackException{
        StackArray s1 = new StackArray();
        // can also use ->
        Stack<Integer> s2 = new Stack<Integer>();
        System.out.println(s1.isEmpty());
        s1.push(23);
        s1.push(3);
        s1.push(-1);
        s1.push(78);
        s1.push(9);
        s1.push(19);

        System.out.println(s1.size());
        System.out.println(s1.peek());
        System.out.println("Popped "+s1.pop());
        System.out.println(s1.peek());

    }
}
