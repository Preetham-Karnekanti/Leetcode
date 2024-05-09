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
    HashMap<Long, Integer> hm;

    public int pathSum(TreeNode root, int targetSum) {
        hm = new HashMap<>();
        hm.put(0L, 1);
        return helper(root, targetSum, 0L);
    }

    public int helper(TreeNode root, int targetSum, long curSum) {
        if (root == null)
            return 0;
        curSum += root.val;
        int count = hm.getOrDefault(curSum - targetSum, 0);
        hm.put(curSum, hm.getOrDefault(curSum, 0) + 1);
        count += helper(root.left, targetSum, curSum);
        count += helper(root.right, targetSum, curSum);
        hm.put(curSum, hm.get(curSum) - 1);
        return count;
    }

}