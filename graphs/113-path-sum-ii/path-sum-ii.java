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
    List<List<Integer>> ans;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        helper(root, targetSum, new ArrayList<>());
        return ans;
    }

    public void helper(TreeNode root, int sum, ArrayList<Integer> path) {
        if (root == null)
            return;
        path.add(root.val);
        if (root.val == sum && root.left == null && root.right == null) {
            ans.add(new ArrayList<>(path));
        }
        helper(root.left, sum - root.val, path);
        helper(root.right, sum - root.val, path);
        path.remove(path.size() - 1);
    }
}