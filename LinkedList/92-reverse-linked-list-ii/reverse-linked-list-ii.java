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
        int n = right - left + 1;
        if (left == 1)
            return reverse(head, right);
        ListNode temp = head;
        for (int i = 1; i < left - 1; i++)
            head = head.next;
        head.next = reverse(head.next, n);
        return temp;
    }

    public ListNode reverse(ListNode head, int count) {
        ListNode cur = head;
        ListNode prev = null;
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