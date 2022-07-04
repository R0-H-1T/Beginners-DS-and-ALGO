package com.DSA.DS.Stack;

import java.util.Stack;

public class StackQues {
    static boolean balancedParenthesis(String str){
        Stack<Character> st = new Stack<>();

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '('){
                st.push('(');
            }else{
                if(st.isEmpty()) return false;
                else st.pop();
            }
        }
        return st.isEmpty();
    }
    static int minBracketReversal(String str){
        if(str.length()%2 != 0) return -1;

        Stack<Character> st = new Stack<>();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '(') st.push('(');
            else{
                if(!st.isEmpty() && st.peek() == '(') st.pop();
                else st.push(')');
            }
        }
        int count = 0;
        while(!st.isEmpty()){
            char x1 = st.pop();
            char x2 = st.pop();
            if(x1 == x1) count++;
            else count+=2;
        }

        return count;
    }
    public static void main(String[] args) {
        String str = "(())";
        System.out.println(balancedParenthesis(str));

        str = ")((("; // => 3 | str="()()"=>0;| str="()(("=> 1

        System.out.println(minBracketReversal(str));
    }
}
