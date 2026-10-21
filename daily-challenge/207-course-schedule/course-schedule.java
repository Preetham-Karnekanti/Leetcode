class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int indegree[] = new int[n];
        for (int e[] : prerequisites) {
            int u = e[0];
            int v = e[1];
            graph.get(v).add(u);
            indegree[u]++;
        }
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            count++;
            for (int ngh : graph.get(cur)) {
                indegree[ngh]--;
                if(indegree[ngh] == 0)
                    q.add(ngh);
            }
        }
        return count == n;
    }
}