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
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> al = new ArrayList<>();
        inorder(root, al);

        return construct(al, 0, al.size() - 1);
    }

    public TreeNode construct(ArrayList<Integer> al, int start, int end) {
        if (start > end)
            return null;
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(al.get(mid));
        root.left = construct(al, start, mid - 1);
        root.right = construct(al, mid + 1, end);
        return root;
    }

    public void inorder(TreeNode root, ArrayList<Integer> al) {
        if (root == null)
            return;
        inorder(root.left, al);
        al.add(root.val);
        inorder(root.right, al);
    }
}