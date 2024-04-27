/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        int depth = 0;
        if (root == null)
            return depth;
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int level_size = queue.size();
            for (int i = 0; i < level_size; i++) {
                Node node = queue.poll();
                if (node.children != null && !node.children.isEmpty()) {
                    for (Node child : node.children) {
                        queue.offer(child);
                    }
                }
            }
            depth += 1;
        }
        return depth;
    }
}