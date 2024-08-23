class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashSet<String> suppliesSet = new HashSet<>();
        for (String s : supplies) {
            suppliesSet.add(s);
        }

        HashMap<String, ArrayList<String>> graph = new HashMap<>();
        HashMap<String, Integer> indegree = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            indegree.put(recipes[i], 0);
            for (String s : ingredients.get(i)) {
                if (suppliesSet.contains(s))
                    continue;
                graph.putIfAbsent(s, new ArrayList<>());
                graph.get(s).add(recipes[i]);
                indegree.put(recipes[i], indegree.get(recipes[i]) + 1);
            }
        }
        Queue<String> q = new LinkedList<>();
        for (String key : indegree.keySet()) {
            if (indegree.get(key) == 0)
                q.add(key);
        }
        ArrayList<String> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            String cur = q.poll();
            ans.add(cur);
            if (graph.containsKey(cur) == false)
                continue;
            for (String ngh : graph.get(cur)) {
                indegree.put(ngh, indegree.get(ngh) - 1);
                if (indegree.get(ngh) == 0)
                    q.add(ngh);
            }
        }
        return ans;
    }
}