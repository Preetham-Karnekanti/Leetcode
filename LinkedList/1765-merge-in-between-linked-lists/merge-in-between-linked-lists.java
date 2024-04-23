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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode aprev = list1;
        for (int i = 1; i < a; i++)
            aprev = aprev.next;
        ListNode bnext = list1;
        for (int i = 0; i < b; i++)
            bnext = bnext.next;
        aprev.next = list2;
        while (list2.next != null)
            list2 = list2.next;
        list2.next = bnext.next;
        return list1;

    }
}