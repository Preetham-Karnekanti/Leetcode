class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int indegree[] = new int[numCourses];
        for (int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<>());
        for (int e[] : prerequisites) {
            adj.get(e[0]).add(e[1]);
            indegree[e[1]]++;
        }
        HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int ngh : adj.get(cur)) {
                hm.putIfAbsent(ngh, new HashSet<>());
                hm.get(ngh).add(cur);
                for (int pre : hm.getOrDefault(cur, new HashSet<>())) {
                    hm.get(ngh).add(pre);
                }
                indegree[ngh]--;
                if (indegree[ngh] == 0)
                    q.add(ngh);
            }
        }
        List<Boolean> answer = new ArrayList<>();
        for (int qu[] : queries) {
            answer.add(hm.getOrDefault(qu[1], new HashSet<>()).contains(qu[0]));
        }
        return answer;
    }
}