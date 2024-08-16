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
    public ListNode plusOne(ListNode head) {
        head = reverse(head);
        int carry = 1;
        ListNode thead = head;
        while (head != null) {
            int sum = head.val + carry;
            head.val = sum % 10;
            carry = sum / 10;
            head = head.next;
        }
        thead = reverse(thead);
        if(carry == 1){
            ListNode newHead = new ListNode(1);
            newHead.next = thead;
            thead = newHead;
        }
        return thead;
    }

    public ListNode reverse(ListNode head){
        ListNode cur = head;
        ListNode prev = null;
        while(cur!= null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}