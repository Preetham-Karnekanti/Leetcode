class Solution {
    public int magnificentSets(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int e[] : edges) {
            int u = e[0] - 1;
            int v = e[1] - 1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int colors[] = new int[n];
        Arrays.fill(colors, -1);
        for (int i = 0; i < n; i++) {
            if (colors[i] != -1)
                continue;
            colors[i] = 0;
            if (!isBipartite(adj, colors, i))
                return -1;
        }
        int distance[] = new int[n];
        for (int i = 0; i < n; i++) {
            distance[i] = findFarthestNode(adj, i, n);
        }
        int ans = 0;
        boolean vis[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (vis[i])
                continue;
            ans += findMaxDistanceInComponent(adj, i, vis, distance);
        }

        return ans;
    }

    public boolean isBipartite(ArrayList<ArrayList<Integer>> adj, int colors[], int node) {
        for (int ngh : adj.get(node)) {
            if (colors[ngh] == colors[node])
                return false;
            if (colors[ngh] != -1)
                continue;
            colors[ngh] = 1 - colors[node];
            if (!isBipartite(adj, colors, ngh))
                return false;
        }
        return true;
    }

    public int findFarthestNode(ArrayList<ArrayList<Integer>> adj, int src, int n) {
        int distance = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        boolean vis[] = new boolean[n];
        vis[src] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int cur = q.poll();
                for (int ngh : adj.get(cur)) {
                    if (!vis[ngh]) {
                        q.add(ngh);
                        vis[ngh] = true;
                    }
                }
            }
            distance++;
        }
        return distance;
    }

    public int findMaxDistanceInComponent(ArrayList<ArrayList<Integer>> adj, int node, boolean vis[], int[] distance) {
        vis[node] = true;
        int max = distance[node];
        for (int ngh : adj.get(node)) {
            if (vis[ngh])
                continue;
            max = Math.max(max, findMaxDistanceInComponent(adj, ngh, vis, distance));
        }
        return max;
    }
}