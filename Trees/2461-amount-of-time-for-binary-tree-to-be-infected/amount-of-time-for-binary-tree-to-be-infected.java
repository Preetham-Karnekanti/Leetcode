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
    TreeNode startNode;

    public int amountOfTime(TreeNode root, int start) {
        startNode = null;
        HashMap<TreeNode, TreeNode> childToParent = getParents(root, start);
        Queue<TreeNode> q = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        q.add(startNode);
        visited.add(startNode);
        int distance = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode node = q.poll();
                if (node.left != null && !visited.contains(node.left)) {
                    q.add(node.left);
                    visited.add(node.left);
                }
                if (node.right != null && !visited.contains(node.right)) {
                    q.add(node.right);
                    visited.add(node.right);
                }
                TreeNode parent = childToParent.get(node);
                if (parent != null && !visited.contains(parent)) {
                    q.add(parent);
                    visited.add(parent);
                }
            }
            distance++;
        }
        return distance;
    }

    public HashMap<TreeNode, TreeNode> getParents(TreeNode root, int start) {
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<TreeNode, TreeNode> childToParent = new HashMap<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.val == start) {
                startNode = node;
            }
            if (node.left != null) {
                q.add(node.left);
                childToParent.put(node.left, node);
            }
            if (node.right != null) {
                q.add(node.right);
                childToParent.put(node.right, node);
            }
        }
        return childToParent;
    }
}

// class Pair{
// TreeNode node;
// int time = 0;
// }