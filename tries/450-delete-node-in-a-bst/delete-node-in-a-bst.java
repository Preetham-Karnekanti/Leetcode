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
    public TreeNode deleteNode(TreeNode root, int key) {
       return helper(root, key);
    }

    public TreeNode helper(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.val > key) {
            root.left = helper(root.left, key);
        } else if (root.val < key) {
            root.right = helper(root.right, key);
        } else {
            if (root.left == null && root.right == null)
                return null;
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;
            int val = findMin(root.right);
            root.val = val;
            root.right = helper(root.right, val);
        }
        return root;
    }

    public int findMin(TreeNode root) {
        int val = -1;
        while (root != null) {
            val = root.val;
            root = root.left;
        }
        return val;
    }
}