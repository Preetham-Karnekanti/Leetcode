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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        collectLeaves(root, ans);
        return ans;
    }

    private int collectLeaves(TreeNode node, List<List<Integer>> ans) {
        if (node == null) {
            return -1;
        }
        int leftHeight = collectLeaves(node.left, ans) + 1;
        int rightHeight = collectLeaves(node.right, ans) + 1;
        node.left = null;
        node.right = null;
        int currHeight = Math.max(leftHeight, rightHeight);

        if (ans.size() == currHeight) {
            ans.add(new ArrayList<>());
        }
        ans.get(currHeight).add(node.val);
        return currHeight;
    }
}