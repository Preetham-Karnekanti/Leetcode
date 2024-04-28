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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            insert(preorder[i], root);
        }
        return root;
    }

    public TreeNode insert(int val, TreeNode root) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val > root.val) {
            root.right = insert(val, root.right);
        } else
            root.left = insert(val, root.left);
        return root;
    }
}