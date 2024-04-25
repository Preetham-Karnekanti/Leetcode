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
        if (lists.length == 0)
            return null;

        ListNode ansList = lists[0];
        for (int i = 1; i < lists.length; i++) {
            ansList = mergeList(ansList, lists[i]);
        }
        return ansList;

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