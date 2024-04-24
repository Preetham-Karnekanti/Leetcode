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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        int counter = 2;
        ListNode prev = head;
        ListNode curr = head.next;
        while (curr != null) {
            ListNode lprev = prev;
            ListNode lcurr = curr;
            int count = 0;
            while (curr != null && count < counter) {
                prev = curr;
                curr = curr.next;
                count++;
            }
            if (Math.min(counter, count) % 2 == 0) {
                ListNode newHead = reverse(lcurr, Math.min(count, counter));
                lprev.next = newHead;
                prev = lcurr;
            }
            counter++;
        }
        return head;
    }

    public ListNode reverse(ListNode head, int count) {
        ListNode prev = null, curr = head, next = null;
        while (curr != null && count > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count--;
        }
        head.next = next;
        return prev;
    }
}