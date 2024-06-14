/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null || node.neighbors == null)
            return node;
        HashMap<Node, Node> hm = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            Node newNode = new Node(cur.val);
            hm.put(cur, newNode);
            for (Node n : cur.neighbors) {
                if (!hm.containsKey(n))
                    q.add(n);
            }
        }
        for (Node key : hm.keySet()) {
            Node cloned = hm.get(key);
            for (Node n : key.neighbors) {
                Node clonedNeighbor = hm.get(n);
                cloned.neighbors.add(clonedNeighbor);
            }
        }
        return hm.get(node);
    }
}