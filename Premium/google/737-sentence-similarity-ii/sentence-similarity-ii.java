class Solution {
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length)
            return false;
        HashMap<String, Integer> hm = new HashMap<>();
        int idx = 0;
        for (List<String> e : similarPairs) {
            String u = e.get(0);
            String v = e.get(1);
            if (!hm.containsKey(u)) {
                hm.put(u, idx);
                idx++;
            }
            if (!hm.containsKey(v)) {
                hm.put(v, idx);
                idx++;
            }
        }
        DisjointSet ds = new DisjointSet(idx + 1);
        for (List<String> e : similarPairs) {
            String u = e.get(0);
            String v = e.get(1);
            int node1 = hm.get(u);
            int node2 = hm.get(v);
            ds.union(node1, node2);
        }
        int n = sentence1.length;
        for (int i = 0; i < n; i++) {
            if (sentence1[i].equals(sentence2[i]))
                continue;
            int node1 = hm.getOrDefault(sentence1[i], -1);
            int node2 = hm.getOrDefault(sentence2[i], -1);
            if (node1 == -1 || node2 == -1)
                return false;
            if (ds.findParent(node1) != ds.findParent(node2))
                return false;
        }
        return true;
    }
}

class DisjointSet {
    int parent[];
    int size[];

    DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findParent(int u) {
        if (parent[u] == u)
            return u;
        return parent[u] = findParent(parent[u]);
    }

    public void union(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);
        if (pu == pv)
            return;
        if (size[pu] > size[pv]) {
            size[pu] += size[pv];
            parent[pv] = pu;
        } else {
            size[pv] += size[pu];
            parent[pu] = pv;
        }

    }
}