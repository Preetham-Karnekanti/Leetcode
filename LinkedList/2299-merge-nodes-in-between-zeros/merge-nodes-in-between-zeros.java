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
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode td = dummy;
        while (head != null) {
            ListNode next = head.next;
            int sum = 0;
            while (next != null && next.val != 0) {
                sum += next.val;
                next = next.next;
            }
            if (sum != 0)
                dummy.next = new ListNode(sum);
            dummy = dummy.next;
            head = next;
        }

        return td.next;
    }
}