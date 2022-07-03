package com.DSA.DS.Stack;

import java.util.Stack;

public class StackQues {
    static boolean balancedParanthesis(String str){
        Stack<Character> st = new Stack<>();

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == ')'){
                st.push(')');
            }else{
                if(st.isEmpty()) return false;
                else st.pop();
            }
        }
        return st.isEmpty();
    }
    public static void main(String[] args) {
        //international reynolds racer gell, it is good to have
    }
}
