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
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.add(0);
        pq.add(0);
        for (Node children : root.children) {
            int childHeight = dfs(children, ans);
            pq.add(childHeight);
        }
        int max1 = pq.poll();
        int max2 = pq.poll();
        ans[0] = Math.max(ans[0], max1 + max2);
        return max1 + 1;
    }
}