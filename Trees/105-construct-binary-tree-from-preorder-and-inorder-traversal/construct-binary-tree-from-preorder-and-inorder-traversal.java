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
    int preIndex;
    HashMap<Integer, Integer> hm;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        hm = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int start, int end) {
        if (start > end)
            return null;
        int val = preorder[preIndex++];
        TreeNode root = new TreeNode(val);
        if (start == end)
            return root;
        int idx = hm.get(val);
        root.left = build(preorder, inorder, start, idx - 1);
        root.right = build(preorder, inorder, idx + 1, end);
        return root;
    }
}