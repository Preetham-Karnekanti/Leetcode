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
        ListNode reverseList = reverse(head);
        int max = Integer.MIN_VALUE;
        ListNode ans = null;
        while (reverseList != null) {
            if (reverseList.val >= max) {
                max = reverseList.val;
                ListNode temp = new ListNode(max);
                temp.next = ans;
                ans = temp;
            }
            reverseList = reverseList.next;
        }
        return ans;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode next = head, curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}