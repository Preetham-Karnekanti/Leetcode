class Solution {
    public int treeDiameter(int[][] edges) {
        if(edges.length == 0)
            return 0;
        int max[] = new int[1];
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        int n = edges.length + 1;
        for (int i = 0; i < n; i++)
            tree.add(new ArrayList<>());
        for (int e[] : edges) {
            int u = e[0];
            int v = e[1];
            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        int[] distance = bfs(tree, 0, n);
        int maxDistance = 0;
        int node = -1;
        for (int i = 0; i < n; i++) {
            if (maxDistance < distance[i]) {
                maxDistance = distance[i];
                node = i;
            }
        }
        distance = bfs(tree, node, n);
        maxDistance = 0;
        node = -1;
        for (int i = 0; i < n; i++) {
            if (maxDistance < distance[i]) {
                maxDistance = distance[i];
            }
        }
        return maxDistance;
    }

    public int[] bfs(ArrayList<ArrayList<Integer>> adj, int start, int n) {
        int distance[] = new int[n];
        Arrays.fill(distance, (int) 1e9);
        Queue<Integer> q = new LinkedList<>();
        distance[start] = 0;
        q.add(start);
        while (!q.isEmpty()) {
            int cur = q.poll();
            int distanceSoFar = distance[cur];
            for (int ngh : adj.get(cur)) {
                if (1 + distanceSoFar < distance[ngh]) {
                    distance[ngh] = 1 + distanceSoFar;
                    q.add(ngh);
                }
            }
        }
        return distance;
    }
}