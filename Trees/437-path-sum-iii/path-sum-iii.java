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
    int count[] = new int[1];

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return 0;
        helper(root, targetSum, 0, count);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return count[0];
    }

    public void helper(TreeNode root, int targetSum, long curSum, int[] count) {
        if (root == null)
            return;
        if (curSum + root.val == targetSum)
            count[0]++;
        helper(root.left, targetSum, curSum + root.val, count);
        helper(root.right, targetSum, curSum + root.val, count);
    }
}