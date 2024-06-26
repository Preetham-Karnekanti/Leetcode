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
        return buildTree(al, 0, al.size() - 1);
    }

    public TreeNode buildTree(ArrayList<Integer> al, int low, int high) {
        if (low > high)
            return null;
        int mid = (low + high) / 2;
        TreeNode root = new TreeNode(al.get(mid));
        if (low == high)
            return root;
        root.left = buildTree(al, low, mid - 1);
        root.right = buildTree(al, mid + 1, high);
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