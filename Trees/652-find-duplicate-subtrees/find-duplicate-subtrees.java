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
    HashMap<String, TreeNode> hm;
    Set<TreeNode> hs;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        hm = new HashMap<>();
        hs = new HashSet<>();
        traverse(root);
        return new ArrayList<>(hs);
    }

    public String traverse(TreeNode root) {
        if (root == null)
            return "";
        String left = traverse(root.left);
        String right = traverse(root.right);
        String cur = left + "#" + right + "#" + root.val;
        if (hm.containsKey(cur)) {
            hs.add(hm.get(cur));
        } else {
            hm.put(cur, root);
        }
        return cur;
    }
}