/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    Node head, prev;

    public Node treeToDoublyList(Node root) {
        if(root == null)
            return root;
        helper(root);
        head.left = prev;
        prev.right = head;
        return head;
    }

    public void helper(Node root) {
        if (root == null)
            return;
        helper(root.left);
        if (prev == null) {
            head = root;
        } else {
            prev.right = root;
            root.left = prev;
        }
        prev = root;
        helper(root.right);
    }
}