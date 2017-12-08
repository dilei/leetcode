package leetcode.add_two_numbers;

import leetcode.common.ListNode;

/**
 * Created by user on 2017/5/11.
 */

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode pre = res;
        ListNode tmp;
        int flag = 0;
        int val = 0;
        do {
            val = l1.val + l2.val + flag;
            tmp = new ListNode(0);
            tmp.val = val % 10;
            flag = val / 10;

            pre.next = tmp;
            pre = tmp;

            l1 = l1.next;
            l2 = l2.next;
        } while (l1 != null && l2 != null);

        while (l1 != null) {
            val = l1.val + flag;
            tmp = new ListNode(0);
            tmp.val = val % 10;
            flag = val / 10;

            pre.next = tmp;
            pre = tmp;

            l1 = l1.next;
        }

        while (l2 != null) {
            val = l2.val + flag;
            tmp = new ListNode(0);
            tmp.val = val % 10;
            flag = val / 10;

            pre.next = tmp;
            pre = tmp;

            l2 = l2.next;
        }

        while (flag > 0) {
            val = flag;
            tmp = new ListNode(0);
            tmp.val = val % 10;
            flag = val / 10;

            pre.next = tmp;
            pre = tmp;
        }

        return res.next;
    }

    public static void main(String[] args) {
        int arr1[] = {6,2,2,6,9,10};
        int arr2[] = {1,9,12,6};
        ListNode l1 = new ListNode(arr1[0]);
        ListNode cur = l1;
        int i = 0;
        for (i=1; i<arr1.length; i++) {
            ListNode tmp = new ListNode(arr1[i]);
            cur.next = tmp;
            cur = tmp;
        }
        /*while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }*/
        ListNode l2 = new ListNode(arr2[0]);
        cur = l2;
        for (i=1; i<arr2.length; i++) {
            ListNode tmp = new ListNode(arr2[i]);
            cur.next = tmp;
            cur = tmp;
        }

        Solution s = new Solution();
        ListNode res = s.addTwoNumbers(l1, l2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

}
