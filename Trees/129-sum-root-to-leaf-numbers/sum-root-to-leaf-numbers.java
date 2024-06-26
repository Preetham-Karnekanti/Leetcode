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

    public int sumNumbers(TreeNode root) {
        int sum[] = new int[1];
        helper(root, 0, sum);
        return sum[0];
    }

    public void helper(TreeNode root, int num, int[] sum) {
        if (root == null)
            return;
        num = num * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum[0] += num;
        }
        helper(root.left, num, sum);
        helper(root.right, num, sum);
    }
}