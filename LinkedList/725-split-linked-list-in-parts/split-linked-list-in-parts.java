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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int size = getSize(head);
        ListNode ans[] = new ListNode[k];
        int i = 0;
        int extra = size % k;
        int partLength = size / k;
        ListNode cur = head;
        int idx = 0;
        while (cur != null) {
            ans[idx++] = cur;
            int currentLength = partLength + ((extra-- > 0) ? 1 : 0);

            for (i = 1; i < currentLength; i++)
                cur = cur.next;

            ListNode temp = cur.next;
            cur.next = null;
            cur = temp;
        }
        return ans;
    }

    public int getSize(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}