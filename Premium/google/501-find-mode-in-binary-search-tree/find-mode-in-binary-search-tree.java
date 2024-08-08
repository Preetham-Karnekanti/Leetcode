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
    int maxCount = 0;
    int curCount = 0;
    int curVal = 0;
    ArrayList<Integer> al;

    public int[] findMode(TreeNode root) {
        al = new ArrayList<>();
        inorder(root);
        int ans[] = new int[al.size()];
        for (int i = 0; i < al.size(); i++)
            ans[i] = al.get(i);
        return ans;
    }

    public void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        curCount = (curVal == root.val) ? curCount + 1 : 1;
        if (maxCount < curCount) {
            maxCount = curCount;
            al.clear();
            al.add(root.val);
        } else if (maxCount == curCount) {
            al.add(root.val);
        }
        curVal = root.val;
        inorder(root.right);
    }
}