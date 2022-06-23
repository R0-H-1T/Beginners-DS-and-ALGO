package com.DSA.DS.Array;

import java.util.Arrays;
import java.util.Scanner;

public class Array {
    public static void main(String[] args) {

        int nums[] = {12,3,11,1,-23,0};


        int[] arr1 = {1,2,3,4,67};

        //checks if sorted ----------------
        if(sorted(arr1)) System.out.println("Sorted");
        else System.out.println("Not Sorted");

        //fiboncci series -----------------
        int n = 6;
        System.out.println(printFibonacciSeries(n));

        //fibonacci series in array ---------------
        int n1 = 6;
        System.out.println(FibSeries(n1));

        // 2sum problem :: given an array find out the sum of a pair that equals to the number provided.
        int n2 = 5;
        int arr3[] = {1,2,23,4,11,3};
        int[] result = twoSum(arr3, n2);
        int[] res = twoPointer(arr3, n2);
        System.out.println(result[0]+" "+result[1]);

        // remove duplicates, exor approach -------------------------------
        int[] arr4 = {1,1,2,3,3,4,2,3,4};
        System.out.println(removeDuplicates(arr4));


    }

    public static void merge(int[] arr, int l, int mid, int r){
    }

    public static void divide(int[] arr, int l, int r){
        if(l<r){
            int mid = l+(r-l)/2;
            divide(arr, l, mid);
            divide(arr, mid+1, r);
            merge(arr, l, mid, r);
        }
    }

    public static int removeDuplicates(int[] arr){
        int x = 0;
        for(int i=0; i< arr.length; i++){
            x = x^arr[i];
        }
        return x;
    }

    public static int[] twoPointer(int[] arr, int n){
        int[] res = new int[2];
        Arrays.sort(arr);
        int i = 0, j = arr.length-1;
        while(i<j){
            if((arr[i] + arr[j]) == n){
                res[i] = arr[i]; res[j] = arr[j];
                return res;
            }else if((arr[i] + arr[j]) > n)  j--;
            else i++;
        }
        return res;
    }

    public static int[] twoSum(int[] arr, int n){
        int res[] = new int[2];
        for(int i=0; i< arr.length; i++){
            for(int j=i+1; j< arr.length; j++){
                if((arr[i] + arr[j]) == n){
                    res[0] = arr[i]; res[1] = arr[j];
                    return res;
                }
            }
        }
        return res;
    }

    public static int printFibonacciSeries(int n){

        int a=0, b=1;
        int res = 0;
        for(int i=0; i<n+1; i++){
            res = a+b;
            int temp = a;
            a=b; b+=temp;
        }
        return res;
    }

    public static int FibSeries(int n){

        int[] arr = new int[n+1];
        arr[0] = 0; arr[1] = 1;
        for(int i=2; i<=n; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }

    public static boolean sorted(int[] arr){
        for(int i=0; i<arr.length-1; i++){
            if(!(arr[i]<arr[i+1])) return false;
        }
        return true;
    }

    public static void increment(Integer i){
        i++;
        System.out.println(i+"increment function");
    } //wrapper class example
}
