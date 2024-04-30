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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> al = new ArrayList<>();
        if (root == null)
            return al;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            while (size-- > 0) {
                Node n = q.poll();

                temp.add(n.val);
                if (n.children != null)
                    q.addAll(n.children);
            }
            al.add(temp);
        }
        return al;
    }
}