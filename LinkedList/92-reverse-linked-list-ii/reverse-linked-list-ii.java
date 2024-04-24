/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int count = right - left + 1;
        if (left == 1)
            return reverse(head, count);
        ListNode temp = head;

        for (int i = 1; i < left - 1; i++) {
            temp = temp.next;
        }
        temp.next = reverse(temp.next, count);
        return head;
    }

    public ListNode reverse(ListNode head, int count) {
        ListNode cur = head, prev = null;
        while (cur != null && count > 0) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            count--;
        }
        head.next = cur;
        return prev;
    }
}