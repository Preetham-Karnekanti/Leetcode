/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node temp = head;
        while (head != null) {
            if (head.child != null) {
                Node next = head.next;
                Node child = head.child;
                head.child = null;
                Node tail = child;
                while (tail.next != null) {
                    tail = tail.next;
                }
                tail.next = next;
                if (next != null)
                    next.prev = tail;
                head.next = child;
                child.prev = head;
            }
            head = head.next;
        }

        return temp;
    }
}