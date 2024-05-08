class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Queue<List<Integer>> q = new LinkedList<>();
        q.add(new ArrayList<>(Arrays.asList(0)));
        ArrayList<List<Integer>> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            List<Integer> path = q.poll();
            if (path.get(path.size() - 1) == graph.length - 1) {
                ans.add(path);
            } else {
                for (int x : graph[path.get(path.size() - 1)]) {
                    List<Integer> newPath = new ArrayList<>(path);
                    newPath.add(x);
                    q.add(newPath);
                }
            }
        }
        return ans;
    }
}