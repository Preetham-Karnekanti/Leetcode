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
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> al = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            al.add(temp.val);
            temp = temp.next;
        }
        int ans[] = new int[al.size()];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < al.size(); i++) {
            while (!st.isEmpty() && al.get(st.peek()) < al.get(i)) {
                ans[st.pop()] = al.get(i);
            }
            st.push(i);
        }
        return ans;
    }
}