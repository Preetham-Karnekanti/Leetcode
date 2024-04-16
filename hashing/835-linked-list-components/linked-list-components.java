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
    public int numComponents(ListNode head, int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i : nums)
            hs.add(i);
        int count = 0;
        while (head != null) {
            boolean hasPair = false;
            while (head != null && hs.contains(head.val)) {
                head = head.next;
                hasPair = true;
            }
            if(hasPair)
                count++;
            if (head != null)
                head = head.next;
        }
        return count;
    }
}