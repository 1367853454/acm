package com.company.leetCode;

/**
 * @author ZHANGWJ
 * @date 2020/9/23 9:49
 */
public class Test26 {

    public static void main(String[] args) {

        Test26 test26 = new Test26();

        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(test26.removeDuplicates(nums));

    }

    public int removeDuplicates(int[] nums) {
        if (null == nums) {
            return 0;
        }
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int slow = 0,fast = 1;
        while (fast < n) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return ++slow;
    }
}
