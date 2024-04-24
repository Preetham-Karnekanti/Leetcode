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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode mid = findMid(head);
        ListNode next = mid.next;
        mid.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(next);
        return merge(l1, l2);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode merged = new ListNode(-1);
        ListNode temp = merged;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                ListNode t = new ListNode(l1.val);
                merged.next = t;
                l1 = l1.next;
            } else {
                ListNode t = new ListNode(l2.val);
                merged.next = t;
                l2 = l2.next;
            }
            merged = merged.next;
        }
        if (l1 != null)
            merged.next = l1;
        if (l2 != null)
            merged.next = l2;
        return temp.next;

    }

    public ListNode findMid(ListNode head) {
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return prev;
    }
}