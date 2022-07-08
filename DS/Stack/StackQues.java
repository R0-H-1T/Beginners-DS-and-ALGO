package com.DSA.DS.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StackQues {

    //--------------  MEDIUM --------------------------------------------
    /*
    *   in linear time
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

    /*
    *   Next greater element
    *   Ex arr = [23, 45, 3, 81, 67] => ans = [2, 3, 3, -1, -1]
    *
    *  1.   If the stack is not empty push the index of the element into the stack and increment i.
    *  2.   If the element is smaller than the element present in the stack, push the index of the elem.
    *           and increment i,
    *       else (i.e elem is greater) pop the index of the elem and assign the value to the index.
    *           Keep checking and assigning it the index if the value is greater. [LOOP]
    *  3.   After traversing through the whole array, check if the stack is empty.
    *       if the stack is not empty, then assign the value -1 to the indices and keep popping the elem
            from teh stack in a loop [LOOP]
    *
    * */
    static int[] nextGreaterNum(int arr[]){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        int i = 0;
        while(i < arr.length){
            if(st.isEmpty() || arr[st.peek()] >= arr[i]) st.push(i++);
            else{
                while(!st.isEmpty() && arr[st.peek()] < arr[i])
                    ans[st.pop()] = arr[i];
            }
        }
        while(!st.isEmpty()){
            ans[st.pop()] = -1;  //if the stack is not empty then there is no
        }
        return ans;
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
        //int[] arr = {6, 1, 5, 4, 5, 2, 6};
        //int[] arr1 = {4, 5, 2, 6};
        //System.out.println(areaOfHistogram(arr1));

        //next greater element
        int[] arr = {11, 2, 1, 3, 21};
        System.out.println(Arrays.toString(nextGreaterNum(arr)));
    }
}
