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
    public int minDiffInBST(TreeNode root) {
        ArrayList<Integer> al = new ArrayList<>();
        inorder(root, al);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < al.size() - 1; i++) {
            min = Math.min(min, al.get(i + 1) - al.get(i));
        }
        return min;
    }

    public void inorder(TreeNode root, ArrayList<Integer> al){
        if(root == null)
            return;
        inorder(root.left, al);
        al.add(root.val);
        inorder(root.right, al);
    }
}