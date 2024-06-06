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
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }

    public ArrayList<TreeNode> helper(int left, int right) {
        if (left > right) {
            ArrayList<TreeNode> a = new ArrayList<>();
            a.add(null);
            return a;
        }
        ArrayList<TreeNode> a = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            ArrayList<TreeNode> leftTree = helper(left, i - 1);
            ArrayList<TreeNode> rightTree = helper(i + 1, right);
            for (TreeNode l : leftTree) {
                for (TreeNode r : rightTree) {
                    TreeNode node = new TreeNode(i);
                    node.left = l;
                    node.right = r;
                    a.add(node);
                }
            }
        }
        return a;
    }
}