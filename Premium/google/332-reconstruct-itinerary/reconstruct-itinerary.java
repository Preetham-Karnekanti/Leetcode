class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> e : tickets) {
            graph.putIfAbsent(e.get(0), new PriorityQueue<>((a, b) -> a.compareTo(b)));
            graph.get(e.get(0)).add(e.get(1));
        }
        ArrayList<String> ans = new ArrayList<>();
        dfs("JFK", ans, graph);
        Collections.reverse(ans);
        return ans;
    }

    public static void dfs(String node, ArrayList<String> ans, HashMap<String, PriorityQueue<String>> graph) {
        PriorityQueue<String> pq = graph.get(node);
        while (pq != null && !pq.isEmpty()) {
            String to = pq.poll();
            dfs(to, ans, graph);
        }
        ans.add(node);
    }
}