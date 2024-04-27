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
    public int sumRootToLeaf(TreeNode root) {
        return helper(root, "");
    }

    public int helper(TreeNode root, String num) {
        if(root == null)
            return 0;
        if (root.left == null && root.right == null) {
            num += root.val;
            return Integer.parseInt(num, 2);
        }
        int sum = 0;
        sum += helper(root.left, num + root.val) + helper(root.right, num + root.val);
        return sum;
    }
}