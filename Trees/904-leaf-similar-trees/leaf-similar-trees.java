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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> first = new ArrayList<>();
        List<Integer> sec = new ArrayList<>();
        traverse(root1, first);
        traverse(root2, sec);
        return first.equals(sec);
    }

    public void traverse(TreeNode root, List<Integer> al){
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            al.add(root.val);
        traverse(root.left, al);
        traverse(root.right, al);
    }
}