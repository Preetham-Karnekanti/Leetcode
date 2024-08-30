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

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        ArrayList<TreeNode> answer = new ArrayList<>();
        HashMap<String, Integer> hm = new HashMap<>();
        helper(root, answer, hm);
        return answer;
    }

    public static String helper(TreeNode root, ArrayList<TreeNode> answer, HashMap<String, Integer> hm) {
        if (root == null)
            return "#";
        String left = helper(root.left, answer, hm);
        String right = helper(root.right, answer, hm);
        String key = root.val + ":" + left + ":" + right;
        if (hm.getOrDefault(key, 0) == 1) {
            answer.add(root);
        }
        hm.put(key, hm.getOrDefault(key, 0) + 1);
        return key;
    }
}