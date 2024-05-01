class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        HashMap<Integer, Node> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Node node = new Node(i);
            hm.put(i, node);
        }

        HashSet<Integer> restrictedSet = new HashSet<>();
        for (int i : restricted) {
            restrictedSet.add(i);
        }
        for (int edge[] : edges) {
            Node parent = hm.get(edge[0]);
            Node child = hm.get(edge[1]);
            parent.children.add(child);
            child.children.add(parent);
        }
        int count = 1;
        Queue<Node> q = new LinkedList<>();
        q.add(hm.get(0));
        HashSet<Integer> visited = new HashSet<>();
        visited.add(0);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Node curr = q.poll();
                ArrayList<Node> children = curr.children;
                if (children != null && children.size() > 0) {
                    for (Node node : children) {
                        if (!restrictedSet.contains(node.val)
                                && !visited.contains(node.val)) {
                            q.add(node);
                            visited.add(node.val);
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}

class Node {
    int val;
    ArrayList<Node> children;

    Node(int val) {
        this.val = val;
        children = new ArrayList<>();
    }
}