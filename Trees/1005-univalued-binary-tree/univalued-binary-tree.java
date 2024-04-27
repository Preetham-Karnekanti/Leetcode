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
    public boolean isUnivalTree(TreeNode root) {
        if (root.left == null && root.right == null)
            return true;
        return helper(root, root.val);
    }

    public boolean helper(TreeNode root, int value){
        if(root == null)
            return true;
        if(root.val != value)
            return false;
        return helper(root.left, value) && helper(root.right, value);
    }
}