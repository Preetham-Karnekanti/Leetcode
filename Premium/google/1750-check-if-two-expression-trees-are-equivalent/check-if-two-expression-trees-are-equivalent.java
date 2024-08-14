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
        int arr1[] = new int[26];
        int arr2[] = new int[26];
        parse(root1, arr1);
        parse(root2, arr2);
        return Arrays.equals(arr1, arr2);
    }

    public void parse(Node root, int[] arr) {
        if (root == null)
            return;
        if (root.val != '+')
            arr[root.val - 'a']++;
        parse(root.left, arr);
        parse(root.right, arr);
    }
}