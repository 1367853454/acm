package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 */
public class Intersect {
    public static void main(String[] args) {
        int [] nums1 = {4,9,5};
        int [] nums2 = {9,4,9,8,4};
        int [] nums = intersect(nums1,nums2);
        for (int i = 0 ; i < nums.length; i++){
            System.out.println(nums[i]);
        }
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        int len1 = 0, len2 = 0;
        len1= nums1.length;
        len2= nums2.length;

        if (len1 == 0 || len2 == 0){
            return new int[0];
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0,j = 0;
        List<Integer> list = new ArrayList();
        while(i < len1 && j < len2){
            if (nums1[i] == nums2[j]){
                list.add(nums1[i]);
                i++;
                j++;
            }
            else if (nums1[i] > nums2[j]){
                j++;
            }
            else {
                i++;
            }
        }
        int [] nums = new int[list.size()];
        int k = 0 ;
        for (Integer num : list){
            nums[k++] = num;
        }
        return nums;
    }



}
