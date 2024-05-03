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
    int idx = 0;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        idx = 0;
       ArrayList<Integer> ans = new ArrayList<>();
       if(solve(root, voyage, ans))
            return ans;
        return new ArrayList<>(Arrays.asList(-1));
    }

    public boolean solve(TreeNode root, int[] voyage, ArrayList<Integer> ans) {
        if (root == null)
            return true;
        if (root.val != voyage[idx])
            return false;
        idx++;
        if (root.left != null && root.left.val != voyage[idx]) {
            ans.add(root.val);
            return solve(root.right, voyage, ans) && solve(root.left, voyage, ans);
        }
        return solve(root.left, voyage, ans) && solve(root.right, voyage, ans);
    }
}