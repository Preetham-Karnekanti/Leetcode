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
        int n = getSize(head);
        ListNode[] ans = new ListNode[k];
        int eachPart = n / k;
        int extra = n % k;
        int idx = 0;
        while (head != null) {
            ans[idx++] = head;
            int curLength = eachPart + (extra > 0 ? 1 : 0);
            extra--;
            for (int i = 1; i < curLength; i++)
                head = head.next;
            ListNode next = head.next;
            head.next = null;
            head = next;
        }
        return ans;
    }

    public int getSize(ListNode head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }
}