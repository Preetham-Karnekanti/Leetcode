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
    ArrayList<Integer> al = new ArrayList<>();
    int maxCount = 0;
    int curCount = 0;
    int curVal;

    public int[] findMode(TreeNode root) {
        inorder(root);
        int[] ans = new int[al.size()];
        for (int i = 0; i < al.size(); i++)
            ans[i] = al.get(i);
        return ans;
    }

    public void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        curCount = (root.val == curVal) ? curCount + 1 : 1;
        if (curCount == maxCount) {
            al.add(root.val);
        } else if (curCount > maxCount) {
            maxCount = curCount;
            al.clear();
            al.add(root.val);
        }
        curVal = root.val;
        inorder(root.right);
    }
}