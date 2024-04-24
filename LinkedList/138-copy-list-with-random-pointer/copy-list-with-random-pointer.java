/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> hm = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            Node n = new Node(temp.val);
            hm.put(temp, n);
            temp = temp.next;
        }
        temp = head;
        Node ans = new Node(0);
        Node dummy = ans;
        while (temp != null) {
            Node ansNode = hm.get(temp);
            ansNode.next = hm.getOrDefault(temp.next, null);
            ansNode.random = hm.getOrDefault(temp.random, null);
            ans.next = ansNode;
            ans = ans.next;
            temp = temp.next;
        }
        return dummy.next;
    }
}