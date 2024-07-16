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

    public String getDirections(TreeNode root, int startValue, int destValue) {
        startNode = null;
        HashMap<TreeNode, TreeNode> childToParent = getParents(root, startValue);
        HashSet<TreeNode> visited = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();
        visited.add(startNode);
        q.add(new Pair(startNode, new StringBuilder("")));
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            TreeNode node = cur.node;
            StringBuilder path = cur.path;
            if (node.val == destValue)
                return path.toString();
            if (node.left != null && !visited.contains(node.left)) {
                StringBuilder nextPath = new StringBuilder(path);
                nextPath.append("L");
                q.add(new Pair(node.left, nextPath));
                visited.add(node.left);
            }
            if (node.right != null && !visited.contains(node.right)) {
                StringBuilder nextPath = new StringBuilder(path);
                nextPath.append("R");
                q.add(new Pair(node.right, nextPath));
                visited.add(node.right);
            }
            TreeNode parent = childToParent.get(node);
            if (parent != null && !visited.contains(parent)) {
                StringBuilder nextPath = new StringBuilder(path);
                nextPath.append("U");
                q.add(new Pair(parent, nextPath));
                visited.add(parent);
            }
        }
        return "";
    }

    public HashMap<TreeNode, TreeNode> getParents(TreeNode root, int startValue) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        HashMap<TreeNode, TreeNode> childToParent = new HashMap<>();
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur.val == startValue)
                startNode = cur;
            if (cur.left != null) {
                childToParent.put(cur.left, cur);
                q.add(cur.left);
            }
            if (cur.right != null) {
                childToParent.put(cur.right, cur);
                q.add(cur.right);
            }
        }
        return childToParent;
    }
}

class Pair {
    TreeNode node;
    StringBuilder path;

    Pair(TreeNode node, StringBuilder path) {
        this.node = node;
        this.path = path;
    }
}