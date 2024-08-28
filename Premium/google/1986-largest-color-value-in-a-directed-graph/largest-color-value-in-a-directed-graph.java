class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int indegree[] = new int[n];
        for (int e[] : edges) {
            int u = e[0];
            int v = e[1];
            indegree[v]++;
            adj.get(u).add(v);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }
        int count[][] = new int[n][26];
        int answer = 0;
        int nodes = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            answer = Math.max(answer, ++count[cur][colors.charAt(cur) - 'a']);
            nodes++;
            for (int ngh : adj.get(cur)) {
                for (int i = 0; i < 26; i++) {
                    // Try to update the frequency of colors for the neighbor to include paths
                    // that use node->neighbor edge.
                    count[ngh][i] = Math.max(count[ngh][i], count[cur][i]);
                }
                indegree[ngh]--;
                if(indegree[ngh] == 0)
                    q.add(ngh);
            }
        }

        return nodes == n ? answer : -1;
    }
}