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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy;
        int sum = 0;
        int carry = 0;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            carry = sum / 10;
            dummy.next = new ListNode(sum % 10);
            dummy = dummy.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            sum = l1.val + carry;
            dummy.next = new ListNode(sum % 10);
            carry = sum / 10;
            dummy = dummy.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            sum = l2.val + carry;
            dummy.next = new ListNode(sum % 10);
            carry = sum / 10;
            dummy = dummy.next;
            l2 = l2.next;
        }
        if(carry != 0)
            dummy.next = new ListNode(carry);
        return reverse(ans.next);
    }

    public ListNode reverse(ListNode head) {
        ListNode curr = head, prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public void print(ListNode head){
        while(head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
        System.out.println();
    }
}