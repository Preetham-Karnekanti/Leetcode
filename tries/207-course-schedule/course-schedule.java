class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<>());
        for (int e[] : prerequisites) {
            adj.get(e[0]).add(e[1]);
        }
        int indegree[] = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int j : adj.get(i))
                indegree[j]++;
        }
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            count++;
            for (int ngh : adj.get(cur)) {
                indegree[ngh]--;
                if (indegree[ngh] == 0)
                    q.add(ngh);
            }
        }
        return count == numCourses;
    }
}