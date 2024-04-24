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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        int size = getSize(head);
        ListNode second = head;
        k = k % size;
        if (k == 0)
            return head;
        int pos = size - k;
        for (int i = 1; i < pos; i++) {
            head = head.next;
        }
        ListNode next = head.next;
        head.next = null;
        ListNode ans = next;
        while (next.next != null) {
            next = next.next;
        }
        next.next = second;

        return ans;
    }

    public int getSize(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}