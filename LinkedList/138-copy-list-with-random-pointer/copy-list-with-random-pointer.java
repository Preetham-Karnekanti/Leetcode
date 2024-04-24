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
        Node temp = head;
        while (temp != null) {
            Node n = new Node(temp.val);
            n.next = temp.next;
            temp.next = n;
            temp = temp.next.next;
        }
        temp = head;
        while (temp != null) {
            if (temp.random != null)
                temp.next.random = temp.random.next;
            temp = temp.next.next;
        }
        Node ans = new Node(0);
        Node dummy = ans;
        while (head != null) {
            Node next = head.next.next;
            ans.next = head.next;
            head.next = next;
            ans = ans.next;
            head = next;
        }
        return dummy.next;
    }
}