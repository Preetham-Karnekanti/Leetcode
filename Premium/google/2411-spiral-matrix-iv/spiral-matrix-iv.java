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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int ans[][] = new int[m][n];
        for (int i[] : ans)
            Arrays.fill(i, -1);
        int startRow = 0;
        int startCol = 0;
        int endRow = m - 1;
        int endCol = n - 1;
        while (head != null) {
            for (int i = startCol; i <= endCol && head != null; i++) {
                ans[startRow][i] = head.val;
                head = head.next;
            }
            startRow++;
            for (int i = startRow; i <= endRow && head != null; i++) {
                ans[i][endCol] = head.val;
                head = head.next;
            }
            endCol--;
            for (int i = endCol; i >= startCol && head != null; i--) {
                ans[endRow][i] = head.val;
                head = head.next;
            }
            endRow--;
            for (int i = endRow; i >= startRow && head != null; i--) {
                ans[i][startCol] = head.val;
                head = head.next;
            }
            startCol++;
        }
        return ans;
    }
}