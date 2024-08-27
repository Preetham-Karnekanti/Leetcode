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
    public int diameter(Node root) {
        int ans[] = new int[1];
        dfs(root, ans);
        return ans[0];
    }

    public int dfs(Node root, int[] ans) {
        int firstMax = 0;
        int secondMax = 0;
        for (Node children : root.children) {
            int childHeight = dfs(children, ans);
            if (childHeight > firstMax) {
                secondMax = firstMax;
                firstMax = childHeight;
            } else if (childHeight > secondMax) {
                secondMax = childHeight;
            }
        }
        ans[0] = Math.max(ans[0], firstMax + secondMax);
        return Math.max(firstMax, secondMax) + 1;
    }
}