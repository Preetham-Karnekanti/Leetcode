/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Stack<Pair> st1 = new Stack<>();
        Stack<Pair> st2 = new Stack<>();
        ArrayList<Integer> al = new ArrayList<>();
        if (root1 != null)
            st1.push(new Pair(root1, 1));
        if (root2 != null)
            st2.push(new Pair(root2, 1));
        while (!st1.isEmpty() || !st2.isEmpty()) {
            while (!st1.isEmpty() && st1.peek().state != 2)
                process(st1);
            while (!st2.isEmpty() && st2.peek().state != 2)
                process(st2);
            if (!st1.isEmpty() && (st2.isEmpty() || st1.peek().node.val < st2.peek().node.val)) {
                al.add(st1.peek().node.val);
                process(st1);
            } else if (!st2.isEmpty()) {
                al.add(st2.peek().node.val);
                process(st2);
            }
        }
        return al;
    }

    public void process(Stack<Pair> st) {
        Pair cur = st.peek();
        if (cur.state == 1) {
            cur.state++;
            if (cur.node.left != null)
                st.push(new Pair(cur.node.left, 1));
        } else if (cur.state == 2) {
            cur.state++;
            if (cur.node.right != null)
                st.push(new Pair(cur.node.right, 1));
        } else {
            st.pop();
        }
    }
}

class Pair {
    TreeNode node;
    int state;

    Pair(TreeNode node, int state) {
        this.node = node;
        this.state = state;
    }
}