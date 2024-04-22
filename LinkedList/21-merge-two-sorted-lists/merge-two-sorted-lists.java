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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                ListNode t = new ListNode(list1.val);
                dummy.next = t;
                list1 = list1.next;
            } else {
                ListNode t = new ListNode(list2.val);
                dummy.next = t;
                list2 = list2.next;
            }
            dummy = dummy.next;
        }
        if (list1 != null)
            dummy.next = list1;
        if (list2 != null)
            dummy.next = list2;
        return temp.next;

    }
}