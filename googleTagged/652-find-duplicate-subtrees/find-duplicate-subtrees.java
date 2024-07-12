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
    HashMap<String, Integer> hm;
    ArrayList<TreeNode> hs;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        hm = new HashMap<>();
        hs = new ArrayList<>();
        traverse(root);
        return hs;
    }

    public String traverse(TreeNode root) {
        if (root == null)
            return "";
        String left = traverse(root.left);
        String right = traverse(root.right);
        String cur = root.val + "^" + left + "^" + right;
        if (hm.getOrDefault(cur, 0) == 1) {
            hs.add(root);
        }
        hm.put(cur, hm.getOrDefault(cur, 0) + 1);
        return cur;
    }
}