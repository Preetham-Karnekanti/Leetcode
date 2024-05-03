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
    TreeNode startNode = null;

    public String getDirections(TreeNode root, int startValue, int destValue) {
        HashMap<TreeNode, TreeNode> childToParent = new HashMap<>();
        getParent(root, startValue, childToParent);
        Queue<Pair> q = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        q.add(new Pair(startNode, ""));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            if (p.node.val == destValue)
                return p.path;
            if (p.node.left != null && !visited.contains(p.node.left)) {
                visited.add(p.node.left);
                q.add(new Pair(p.node.left, p.path + "L"));
            }
            if (p.node.right != null && !visited.contains(p.node.right)) {
                visited.add(p.node.right);
                q.add(new Pair(p.node.right, p.path + "R"));
            }
            TreeNode parent = childToParent.get(p.node);
            if (parent != null && !visited.contains(parent)) {
                visited.add(parent);
                q.add(new Pair(parent, p.path + "U"));
            }
        }
        return null;
    }

    public void getParent(TreeNode root, int startValue, HashMap<TreeNode, TreeNode> childToParent) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.val == startValue)
                startNode = node;
            if (node.left != null) {
                q.add(node.left);
                childToParent.put(node.left, node);
            }
            if (node.right != null) {
                q.add(node.right);
                childToParent.put(node.right, node);
            }
        }
    }
}

class Pair {
    String path;
    TreeNode node;

    Pair(TreeNode node, String path) {
        this.path = path;
        this.node = node;
    }
}