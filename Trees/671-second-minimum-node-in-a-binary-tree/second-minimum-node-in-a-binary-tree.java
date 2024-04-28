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
    public int findSecondMinimumValue(TreeNode root) {
        Set<Integer> hs = new HashSet();
        find(root, hs);
        int k = 0;
        int[] ans = new int[hs.size()];
        for (var i : hs) {
            ans[k++] = i;
        }
        Arrays.sort(ans);
        if (ans.length == 1)
            return -1;
        return ans[1];
    }

    static void find(TreeNode root, Set<Integer> hs) {
        if (root == null)
            return;
        find(root.left, hs);
        hs.add(root.val);
        find(root.right, hs);
    }
}