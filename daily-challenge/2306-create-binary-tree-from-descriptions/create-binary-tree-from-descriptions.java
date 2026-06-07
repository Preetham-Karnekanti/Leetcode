/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> nodes = new HashMap<>();
        HashSet<Integer> children = new HashSet<>();
        for (int d[] : descriptions) {
            int parent = d[0];
            int child = d[1];
            int isLeft = d[2];
            TreeNode parentNode = nodes.getOrDefault(parent, new TreeNode(parent));
            TreeNode childNode = nodes.getOrDefault(child, new TreeNode(child));
            if (isLeft == 1) {
                parentNode.left = childNode;
            } else
                parentNode.right = childNode;
            nodes.putIfAbsent(parent, parentNode);
            nodes.putIfAbsent(child, childNode);
            children.add(child);
        }
        for (int node : nodes.keySet()) {
            if (children.contains(node) == false)
                return nodes.get(node);
        }
        return null;
    }
}