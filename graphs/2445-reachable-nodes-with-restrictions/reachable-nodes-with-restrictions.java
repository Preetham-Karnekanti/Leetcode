class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int e[] : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[n];
        for (int i : restricted)
            vis[i] = true;
        if(vis[0])
            return 0;
        int count = 1;
        q.add(0);
        vis[0] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int adjNode : adj.get(cur)) {
                if (!vis[adjNode]) {
                    vis[adjNode] = true;
                    q.add(adjNode);
                    count++;
                }
            }
        }
        return count;
    }
}