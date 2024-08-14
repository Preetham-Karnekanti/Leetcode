class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        Queue<Integer> q = new LinkedList<>();
        int indegree[] = new int[edges.length];
        for (int i = 0; i < edges.length; i++) {
            if (edges[i] != -1)
                indegree[edges[i]]++;
        }
        for (int i = 0; i < edges.length; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }
        boolean vis[] = new boolean[n];
        while (!q.isEmpty()) {
            int cur = q.poll();
            vis[cur] = true;
            int ngh = edges[cur];
            if (ngh != -1) {
                indegree[ngh]--;
                if (indegree[ngh] == 0)
                    q.add(ngh);
            }
        }
        int answer = -1;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                int ngh = edges[i];
                int count = 1;
                vis[i] = true;
                while (ngh != i) {
                    count++;
                    vis[ngh] = true;
                    ngh = edges[ngh];
                }
                answer = Math.max(answer, count);
            }
        }
        return answer;
    }
}