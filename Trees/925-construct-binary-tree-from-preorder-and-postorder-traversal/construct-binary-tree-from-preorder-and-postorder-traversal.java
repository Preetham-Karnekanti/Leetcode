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
    HashMap<Integer, Integer> map;
    int preIndex = 0;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }
        return helper(preorder, postorder, 0, postorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int[] postorder, int start, int end) {
        if (start > end)
            return null;
        TreeNode root = new TreeNode(preorder[preIndex++]);

        if (start == end)
            return root;
        int idx = map.get(preorder[preIndex]);
        root.left = helper(preorder, postorder, start, idx);
        root.right = helper(preorder, postorder, idx + 1, end-1);
        return root;
    }
}