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
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;
        ListNode lesser = new ListNode(-1);
        ListNode greater = new ListNode(-1);
        ListNode tGreater = greater;
        ListNode tLesser = lesser;
        while (head != null) {
            if (head.val < x) {
                lesser.next = head;
                ListNode next = head.next;
                head.next = null;
                head = next;
                lesser = lesser.next;
            } else {
                greater.next = head;
                ListNode next = head.next;
                head.next = null;
                head = next;
                greater = greater.next;
            }
        }
        if (tLesser.next == null)
            return tGreater.next;
        else if (tGreater.next == null)
            return tLesser.next;
        lesser.next = tGreater.next;
        return tLesser.next;
    }
}