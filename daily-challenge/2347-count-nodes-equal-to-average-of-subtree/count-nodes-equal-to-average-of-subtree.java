/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans;

    public int averageOfSubtree(TreeNode root) {
        ans = 0;
        helper(root);
        return ans;
    }

    public int[] helper(TreeNode root) {
        if (root == null) {
            return new int[] { 0, 0 };
        }
        int left[] = helper(root.left);
        int right[] = helper(root.right);
        int lsum = left[0];
        int lcount = left[1];
        int rsum = right[0];
        int rcount = right[1];
        int count = lcount + rcount + 1;
        int sum = lsum + rsum + root.val;
        System.out.println(sum + " " + count);
        if (count > 0 && (sum / count) == root.val) {
            ans++;
        }
        return new int[] { sum, count };
    }
}