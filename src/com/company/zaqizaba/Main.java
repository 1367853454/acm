package com.company.zaqizaba;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public void rotate(int[] nums, int k) {
        if(nums.length == 0 || nums.length == 1 || k == 0){
            return;
        }
        k = k % nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k);
        reverse(nums,k-1,nums.length-1);

    }

    public void reverse(int[] arr,int begin,int end){
        int half=(end-begin+1)/2;
        int tar;
        for(int i=0;i<half;i++){
            tar=arr[begin];
            arr[begin]=arr[end];
            arr[end]=tar;
            begin++;
            end--;
        }
    }
}
