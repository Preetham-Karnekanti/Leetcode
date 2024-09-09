class Solution {
    ArrayList<ArrayList<Integer>> graph;
    int n, k;
    HashMap<Integer, Integer> hm;

    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        graph = new ArrayList<>();
        hm = new HashMap<>();
        this.n = n;
        this.k = k;
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        int indegree[] = new int[n];
        for (int r[] : relations) {
            int u = r[0] - 1;
            int v = r[1] - 1;
            graph.get(u).add(v);
            indegree[v]++;
        }

        int mask = 0;
        for (int i = 0; i < n; i++) {
            mask = mask | (1 << i);
        }

        return helper(mask, indegree);
    }

    public int helper(int mask, int[] indegree) {
        if (mask == 0)
            return 0;
        if (hm.containsKey(mask))
            return hm.get(mask);
        ArrayList<Integer> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (checkbit(mask, i) == 1 && indegree[i] == 0)
                nodes.add(i);
        }
        int ans = Integer.MAX_VALUE;
        for (List<Integer> kNodes : generateCombinations(nodes, Math.min(k, nodes.size()))) {
            int newMask = mask;
            int newIndegree[] = indegree.clone();

            for (int node : kNodes) {
                newMask = newMask ^ (1 << node);
                for (int child : graph.get(node)) {
                    newIndegree[child]--;
                }
            }
            ans = Math.min(ans, 1 + helper(newMask, newIndegree));
        }
        hm.put(mask, ans);
        return ans;
    }

    public List<List<Integer>> generateCombinations(ArrayList<Integer> nodes, int size) {
        List<List<Integer>> result = new ArrayList<>();
        generateHelper(nodes, size, 0, new ArrayList<>(), result);
        return result;
    }

    public void generateHelper(ArrayList<Integer> nums, int size, int idx, List<Integer> temp,
            List<List<Integer>> result) {
        if (size == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (idx == nums.size())
            return;
        temp.add(nums.get(idx));
        generateHelper(nums, size - 1, idx + 1, temp, result);
        temp.remove(temp.size() - 1);
        generateHelper(nums, size, idx + 1, temp, result);
    }

    public int checkbit(int num, int i) {
        num = num >> i;
        return (num & 1);

    }
}