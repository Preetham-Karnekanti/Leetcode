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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i : nums)
            hs.add(i);
        ListNode dummy = new ListNode(-1);
        ListNode t = dummy;
        while (head != null) {
            while (head != null && hs.contains(head.val))
                head = head.next;
            dummy.next = head;
            dummy = dummy.next;
            if (head != null)
                head = head.next;
        }
        return t.next;
    }
}