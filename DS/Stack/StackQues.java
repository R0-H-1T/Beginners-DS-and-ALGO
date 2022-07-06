package com.DSA.DS.Stack;

import java.util.ArrayList;
import java.util.List;
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

    static int[] stockSpan(int arr[]){
        if(arr.length == 0) return arr;

        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        st.push(0);
        ans[0] = 1;

        for(int i=1; i<arr.length; i++){
            int currElem = arr[i];
            while(!st.isEmpty() && currElem>arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()) ans[i]=i+1;
            else ans[i]=i-st.peek();

            st.push(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {34, 86, 21, 45, 98, 70};
        for(int n : stockSpan(arr)){
            System.out.print(n+" ");
        }
    }
}
