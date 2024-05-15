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
        int k = lists.length;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        for (int i = 0; i < k; i++) {
            ListNode temp = lists[i];
            while (temp != null) {
                pq.add(temp);
                temp = temp.next;
            }
        }
        ListNode head = pq.poll();
        ListNode temp = head;
        while (!pq.isEmpty()) {
            temp.next = pq.poll();
            temp = temp.next;
        }
        if (temp != null)
            temp.next = null;
        return head;
    }
}