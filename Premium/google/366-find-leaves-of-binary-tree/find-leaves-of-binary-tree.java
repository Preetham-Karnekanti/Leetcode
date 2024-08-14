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
        while (root != null) {
            List<Integer> leaves = new ArrayList<>();
            root = addLeaves(root, leaves);
            ans.add(leaves);
        }
        return ans;
    }

    public TreeNode addLeaves(TreeNode root, List<Integer> ans){
        if(root == null)
            return null;
        if(root.left == null && root.right == null){
            ans.add(root.val);
            return null;
        }
        root.left = addLeaves(root.left, ans);
        root.right = addLeaves(root.right, ans);
        return root;
    }
}