class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int indegree[] = new int[numCourses];
        for (int e[] : prerequisites) {
            int u = e[0];
            int v = e[1];
            indegree[u]++;
            graph.get(v).add(u);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }
        int answer[] = new int[numCourses];
        int idx = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            answer[idx++] = cur;
            for (int ngh : graph.get(cur)) {
                indegree[ngh]--;
                if (indegree[ngh] == 0)
                    q.add(ngh);
            }
        }
        return idx == numCourses ? answer : new int[0];
    }
}