/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode temp = head;
        while (head != null) {
            int count = 0;
            while (count < m - 1 && head != null) {
                head = head.next;
                count++;
            }
            ListNode prev = head;
            count = 0;
            while (count <= n && head != null) {
                head = head.next;
                count++;
            }
            if (prev != null)
                prev.next = head;
        }
        return temp;
    }
}