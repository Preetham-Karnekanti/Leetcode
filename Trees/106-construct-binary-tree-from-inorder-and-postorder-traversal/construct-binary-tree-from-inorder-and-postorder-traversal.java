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
    int pIndex;
    HashMap<Integer, Integer> hm;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        pIndex = inorder.length - 1;
        hm = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            hm.put(inorder[i], i);
        return buildTree(inorder, postorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int start, int end) {
        if (start > end)
            return null;
        int val = postorder[pIndex--];
        TreeNode root = new TreeNode(val);
        if (start == end)
            return root;
        int idx = hm.get(val);
        root.right = buildTree(inorder, postorder, idx + 1, end);
        root.left = buildTree(inorder, postorder, start, idx - 1);
        return root;
    }
}