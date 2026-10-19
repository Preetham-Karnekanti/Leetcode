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
    HashSet<String> hs;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        hs = new HashSet<>();
        String str1 = serialize(subRoot);
        String str2 = serialize2(root);
        return hs.contains(str1);
    }

    public String serialize(TreeNode root) {
        if (root == null)
            return "#";
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val + " " + left + " " + right;
    }
    public String serialize2(TreeNode root) {
        if (root == null)
            return "#";
        String left = serialize2(root.left);
        String right = serialize2(root.right);
        hs.add(root.val + " " + left + " " + right);
        return root.val + " " + left + " " + right;
    }
}