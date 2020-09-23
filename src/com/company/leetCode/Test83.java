package com.company.leetCode;

/**
 * @author ZHANGWJ
 * @date 2020/9/23 10:08
 *
 */
public class Test83 {

    public static void main(String[] args) {

        ListNode head = new ListNode(0);
        ListNode one = new ListNode(1);
        ListNode one_1 = new ListNode(1);
        ListNode one_2 = new ListNode(1);
        ListNode two = new ListNode(2);
        head.next = one;
        one.next = one_1;
        one_1.next = one_2;
        one_2.next = two;

        Test83 test83 = new Test83();

        System.out.println(test83.deleteDuplicates(head));
    }

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head.next;
        while (null != fast) {
            if (fast.val != slow.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            return "next: " + this.next + "val: " + this.val;
        }
    }

}
