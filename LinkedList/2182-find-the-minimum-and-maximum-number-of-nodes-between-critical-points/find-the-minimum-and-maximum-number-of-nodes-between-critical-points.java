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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ArrayList<Integer> al = new ArrayList<>();
        int idx = 1;
        ListNode prev = head;
        head = head.next;
        if (head.next == null)
            return new int[] { -1, -1 };
        while (head.next != null) {
            if (head.val > prev.val && head.val > head.next.val) {
                al.add(idx);
            } else if (head.val < prev.val && head.val < head.next.val) {
                al.add(idx);
            }
            idx++;
            prev = head;
            head = head.next;
        }
        int size = al.size();
        if (size == 0 || size == 1)
            return new int[] { -1, -1 };
        int ans[] = new int[2];
        ans[0] = Integer.MAX_VALUE;
        ans[1] = al.get(size - 1) - al.get(0);
        for (int i = 0; i < al.size() - 1; i++) {
            ans[0] = Math.min(ans[0], al.get(i + 1) - al.get(i));
        }
        return ans;
    }
}