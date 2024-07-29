/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    TreeNode head, prev;

    public boolean findTarget(TreeNode root, int k) {
        prev = head = null;
        convertToDLL(root);
        TreeNode tail = head;
        while (tail.right != null) {
            tail = tail.right;
        }
        while (head != tail) {
            int sum = head.val + tail.val;
            if (sum == k)
                return true;
            if (sum > k) {
                tail = tail.left;
            } else
                head = head.right;
        }
        return false;
    }

    public void convertToDLL(TreeNode root) {
        if (root == null)
            return;
        convertToDLL(root.left);
        if (prev == null) {
            head = root;
        }
        if (prev != null) {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        convertToDLL(root.right);
    }
}