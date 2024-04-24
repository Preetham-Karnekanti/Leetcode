class Solution {
    private static ListNode reverse(ListNode head, int n) {
        ListNode temp = head, newHead = null, node = null;
        for (int i = 0; i < n; i++) {
            node = temp;
            temp = temp.next;
            node.next = newHead;
            newHead = node;
        }
        head.next = temp;
        return newHead;
    }

    public ListNode reverseBetween(ListNode head, int l, int r) {
        int n = r - l + 1;
        if (n < 2)
            return head;
        if (l == 1)
            return reverse(head, n);
        ListNode temp = head;
        for (int i = 2; i < l; i++)
            temp = temp.next;
        temp.next = reverse(temp.next, n);
        return head;
    }
}