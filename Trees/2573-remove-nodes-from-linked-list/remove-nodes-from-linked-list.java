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
    public ListNode removeNodes(ListNode head) {
        ListNode reversed = reverse(head);
        int maxSofar = Integer.MIN_VALUE;
        ListNode temp = null;
        while (reversed != null) {
            if (reversed.val >= maxSofar) {
                maxSofar = reversed.val;
                ListNode n = new ListNode(reversed.val);
                if (temp == null) {
                    temp = n;
                } else {
                    n.next = temp;
                    temp = n;
                }
            }
            reversed = reversed.next;
        }
        return temp;
    }

    public ListNode reverse(ListNode head) {
        ListNode cur = head, prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}