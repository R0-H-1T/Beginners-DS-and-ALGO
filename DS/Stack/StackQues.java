package com.DSA.DS.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackQues {

    //--------------  MEDIUM --------------------------------------------
    /*
    *
    *
    * */
    static int areaOfHistogram(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int i = 0, max_area = 0;
        while(i<n){
            if(st.isEmpty() || arr[i]>=arr[st.peek()]) st.push(i++);
            else{
                int x = st.pop();
                int rightIndex = i;
                int leftIndex = st.isEmpty()? 0 : st.peek();
                int area = st.isEmpty()? arr[x]*rightIndex : arr[x]*(rightIndex-leftIndex-1);
                max_area = Math.max(area, max_area);
            }
        }
        while(!st.isEmpty()){
            int x = st.pop();
            int rightIndex = i;
            int leftIndex = st.isEmpty()? 0 : st.peek();
            int area = st.isEmpty()? arr[x]*rightIndex : arr[x]*(rightIndex-leftIndex-1);
            max_area = Math.max(area, max_area);
        }
        return max_area;
    }









    // <---------------------------------------------------------------------------->
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

    static void reverseStack(Stack<Integer> st){
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        while(!st.isEmpty()){
            st1.push(st.pop());
        }
        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }
        while(!st2.isEmpty()){
            st.push(st2.pop());
        }
    }
    public static void main(String[] args) {
        //Stock Span
//        int[] arr = {34, 86, 21, 45, 98, 70};
//        for(int n : stockSpan(arr)){
//            System.out.print(n+" ");
//        }

        //Reverse Stack
//        Stack<Integer> st = new Stack<>();
//        st.push(1);
//        st.push(2);
//        st.push(3);
//        st.push(4);
//        reverseStack(st);
//        System.out.println(st.peek());

        //Medium -------------------------------------------->
        //max area of histogram
        int[] arr = {6, 1, 5, 4, 5, 2, 6};
        int[] arr1 = {4, 5, 2, 6};
        System.out.println(areaOfHistogram(arr1));
    }
}
