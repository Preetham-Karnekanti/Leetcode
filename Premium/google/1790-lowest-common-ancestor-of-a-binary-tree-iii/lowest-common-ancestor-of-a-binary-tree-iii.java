/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        HashSet<Node> hs = new HashSet<>();
        Node pNode = p;
        while (pNode != null) {
            hs.add(pNode);
            pNode = pNode.parent;
        }
        Node qNode = q;
        while (qNode != null) {
            if (hs.contains(qNode))
                return qNode;
            qNode = qNode.parent;
        }
        return null;
    }
}