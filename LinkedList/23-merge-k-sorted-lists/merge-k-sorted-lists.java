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
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeKLists(ListNode[] lists, int lo, int hi) {
        if (lo > hi)
            return null;
        if (lo == hi)
            return lists[lo];

        int m = (lo + hi) / 2;
        ListNode left = mergeKLists(lists, lo, m);
        ListNode right = mergeKLists(lists, m + 1, hi);
        return mergeList(left, right);
    }

    public ListNode mergeList(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null)
            return null;
        if (list1 == null)
            return list2;

        if (list2 == null)
            return list1;

        ListNode mergedList = new ListNode(0);
        ListNode temp = mergedList;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                mergedList.next = list1;
                list1 = list1.next;
            } else {
                mergedList.next = list2;
                list2 = list2.next;
            }
            mergedList = mergedList.next;

        }

        if (list1 != null)
            mergedList.next = list1;
        if (list2 != null)
            mergedList.next = list2;
        return temp.next;
    }
}