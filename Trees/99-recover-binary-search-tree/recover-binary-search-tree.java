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
    TreeNode prev;
    TreeNode first, second, issue;

    public void recoverTree(TreeNode root) {
        inorder(root);
        if (first != null && second != null) {
            swap(first, second);
            return;
        }
        swap(first, issue);
    }

    public void swap(TreeNode a, TreeNode b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }

    public void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        if (prev != null && prev.val > root.val) {
            // violation
            if (first == null) {
                first = prev;
                issue = root;
            } else {
                second = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}