class Solution {
    public int minReorder(int n, int[][] connections) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int e[] : connections) {
            int u = e[0];
            int v = e[1];
            graph.get(u).add(new Pair(v, 0));
            graph.get(v).add(new Pair(u, 1));
        }
        Queue<Integer> q = new LinkedList<>();
        int visited[] = new int[n];
        visited[0] = 1;
        q.add(0);
        int count = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            for (Pair neighbour : graph.get(node)) {
                int adjNode = neighbour.node;
                int wt = neighbour.wt;
                if (visited[adjNode] == 0) {
                    visited[adjNode] = 1;
                    q.add(adjNode);
                    if (wt == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}

class Pair {
    int node, wt;

    Pair(int n, int w) {
        node = n;
        wt = w;
    }
}
