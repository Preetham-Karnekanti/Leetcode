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
    public Node moveSubTree(Node root, Node p, Node q) {
        if (q.children.contains(p))
            return root;
        Node pParent = findParent(root, p);
        Node qParent = findParent(root, q);
        if (p == root) {
            qParent.children.remove(q);
            q.children.add(root);
            return q;
        }
        if (isSubset(p, q)) {
            int idx = pParent.children.indexOf(p);
            pParent.children.set(idx, q);
            qParent.children.remove(q);
            q.children.add(p);
        } else {
            pParent.children.remove(p);
            q.children.add(p);
        }
        return root;
    }

    public Node findParent(Node root, Node target) {
        for (Node child : root.children) {
            if (child == target)
                return root;
            Node res = findParent(child, target);
            if (res != null)
                return res;
        }
        return null;
    }

    public boolean isSubset(Node p, Node q) {
        for (Node next : p.children) {
            if (next == q || isSubset(next, q))
                return true;
        }
        return false;
    }
}
