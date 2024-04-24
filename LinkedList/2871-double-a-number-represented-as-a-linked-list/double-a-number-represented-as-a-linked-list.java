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
    public ListNode doubleIt(ListNode head) {
        ListNode newHead = reverse(head);
        ListNode temp = newHead;
        int carry = 0;
        while (newHead != null) {
            int val = 2 * newHead.val + carry;
            newHead.val = val % 10;
            carry = val / 10;
            newHead = newHead.next;
        }

        temp = reverse(temp);
        if (carry != 0) {
            ListNode n = new ListNode(carry);
            n.next = temp;
            return n;
        }
        return temp;
    }

    public ListNode reverse(ListNode head) {
        ListNode curr = head, prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}