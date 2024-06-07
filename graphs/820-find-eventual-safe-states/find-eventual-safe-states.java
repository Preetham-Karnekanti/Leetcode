class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = graph.length;
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            for (int j : graph[i])
                adj.get(j).add(i);
        }
        Queue<Integer> q = new LinkedList<>();
        int indegree[] = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j : adj.get(i))
                indegree[j]++;
        }
        for (int i = 0; i < n; i++)
            if (indegree[i] == 0)
                q.add(i);
        List<Integer> al = new ArrayList<>();
        while (!q.isEmpty()) {
            int cur = q.poll();
            al.add(cur);
            for (int ngh : adj.get(cur)) {
                indegree[ngh]--;
                if (indegree[ngh] == 0)
                    q.add(ngh);
            }
        }
        Collections.sort(al);
        return al;
    }
}