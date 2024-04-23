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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode thead = head;
        while (head.next != null) {
            int gcd = computeGcd(head.val, head.next.val);
            ListNode temp = new ListNode(gcd);
            ListNode next = head.next;
            head.next = temp;
            temp.next = next;
            head = head.next.next;
        }

        return thead;
    }

    public int computeGcd(int a, int b) {
        if (a == 0)
            return b;
        if (b == 0)
            return a;
        return computeGcd(b, a % b);
    }
}