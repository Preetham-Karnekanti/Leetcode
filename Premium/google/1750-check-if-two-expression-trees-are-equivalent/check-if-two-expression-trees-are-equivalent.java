/**
 * Definition for a binary tree node.
 * class Node {
 * char val;
 * Node left;
 * Node right;
 * Node() {this.val = ' ';}
 * Node(char val) { this.val = val; }
 * Node(char val, Node left, Node right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean checkEquivalence(Node root1, Node root2) {
        String s1 = parse(root1);
        String s2 = parse(root2);
        char ch1[] = s1.toCharArray();
        char ch2[] = s2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        return Arrays.equals(ch1, ch2);
    }

    public String parse(Node root) {
        if (root == null)
            return "";
        String left = parse(root.left);
        String right = parse(root.right);

        return left + root.val + right;
    }
}