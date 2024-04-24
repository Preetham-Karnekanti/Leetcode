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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        ListNode t = dummy;
        while (head != null) {
            ListNode curr = head;
            head = head.next;
            while (head != null && head.val == curr.val) {
                head = head.next;
            }
            if (curr.next == head) {
                ListNode ptr = new ListNode(curr.val);
                dummy.next = ptr;
                dummy = dummy.next;
            }
        }
        return t.next;
    }
}