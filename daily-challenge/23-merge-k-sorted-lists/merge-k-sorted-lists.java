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
            if (lists[i] != null)
                pq.add(lists[i]);
        }
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        while (!pq.isEmpty()) {
            ListNode cur = pq.poll();
            temp.next = cur;
            temp = temp.next;
            if (cur.next != null){
                pq.add(cur.next);
            }
        }
        if (temp != null)
            temp.next = null;
        return head.next;
    }
}