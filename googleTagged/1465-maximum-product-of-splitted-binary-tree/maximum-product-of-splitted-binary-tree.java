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
    int m = (int) 1e9 + 7;

    public int maxProduct(TreeNode root) {
        long totalSum = findTreeSum(root);
        long max[] = new long[1];
        findMaxProduct(root, totalSum, max);
        return (int) (max[0] % m);
    }

    public long findTreeSum(TreeNode root) {
        if (root == null)
            return 0;
        long left = findTreeSum(root.left);
        long right = findTreeSum(root.right);
        return left + right + root.val;
    }

    public long findMaxProduct(TreeNode root, long totalSum, long max[]) {
        if (root == null)
            return 0;
        long left = findMaxProduct(root.left, totalSum, max);
        long right = findMaxProduct(root.right, totalSum, max);
        max[0] = Math.max(max[0], left * (totalSum - left));
        max[0] = Math.max(max[0], right * (totalSum - right));
        return left + right + root.val;
    }
}