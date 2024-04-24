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
        if(head == null)
            return head;
        while (head != null) {
            Node cur = head;
            if (cur.child != null) {
                Node children = cur.child;
                Node next = cur.next;
                cur.next = children;
                children.prev = cur;
                Node childrenTail = children;
                while (childrenTail.next != null) {
                    childrenTail = childrenTail.next;
                }
                childrenTail.next = next;
                if(next!=null)
                next.prev = childrenTail;
                cur.child = null;
            }
            head = head.next;
        }
        return temp;
    }
}