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
    ArrayList<TreeNode> al;
    HashSet<Integer> hs;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        al = new ArrayList<>();
        if (root == null)
            return al;
        hs = new HashSet<>();
        for (int i : to_delete)
            hs.add(i);
        if (!hs.contains(root.val))
            al.add(root);
        helper(root);
        return al;
    }

    public TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = helper(root.left);
        root.right = helper(root.right);
        if (hs.contains(root.val)) {
            if (root.left != null)
                al.add(root.left);
            if (root.right != null)
                al.add(root.right);
            return null;
        }
        return root;
    }
}