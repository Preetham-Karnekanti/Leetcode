class Solution {
    public int[][] validArrangement(int[][] pairs) {
        HashMap<Integer, Deque<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> outDegree = new HashMap<>();
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        for (int p[] : pairs) {
            int u = p[0];
            int v = p[1];
            graph.putIfAbsent(u, new ArrayDeque<>());
            graph.get(u).add(v);
            outDegree.put(u, outDegree.getOrDefault(u, 0) + 1);
            inDegree.put(v, inDegree.getOrDefault(v, 0) + 1);
        }

        int startNode = pairs[0][0];
        for (int node : graph.keySet()) {
            if (outDegree.getOrDefault(node, 0) == inDegree.getOrDefault(node, 0) + 1) {
                startNode = node;
                break;
            }
        }

        List<Integer> path = new ArrayList<>();
        dfs(startNode, graph, path);

        Collections.reverse(path);

        int answer[][] = new int[pairs.length][2];
        int idx = 0;
        for (int i = 1; i < path.size(); i++) {
            answer[idx][0] = path.get(i - 1);
            answer[idx][1] = path.get(i);
            idx++;
        }

        return answer;
    }

    public void dfs(int node, HashMap<Integer, Deque<Integer>> graph, List<Integer> path) {
        Deque<Integer> ngh = graph.getOrDefault(node, new ArrayDeque<>());
        while (!ngh.isEmpty()) {
            dfs(ngh.pollFirst(), graph, path);
        }

        path.add(node);
    }
}