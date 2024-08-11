/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public Node findRoot(List<Node> tree) {
        Map<Node, Integer> map = new HashMap<>();
        for (Node node : tree) {
            if (node.children != null) {
                map.put(node, map.getOrDefault(node, 0) + 1);
                for (Node c : node.children) {
                    map.put(c, map.getOrDefault(c, 0) + 1);
                }
            }
        }
        for (Node node : map.keySet()) {
            if (map.get(node) == 1)
                return node;
        }
        return null;
    }
}