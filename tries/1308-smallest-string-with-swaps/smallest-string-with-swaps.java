class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        DisjointSet ds = new DisjointSet(n);
        for (List<Integer> pair : pairs) {
            ds.union(pair.get(0), pair.get(1));
        }
        HashMap<Integer, PriorityQueue<Character>> hm = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int parent = ds.findParent(i);
            hm.putIfAbsent(parent, new PriorityQueue<>());
            hm.get(parent).add(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            int parent = ds.findParent(i);
            sb.append(hm.get(parent).poll());
        }
        return sb.toString();
    }
}

class DisjointSet {
    int parent[];
    int size[];

    DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];
        Arrays.fill(size, 1);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
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
            parent[pu] = pu;
            size[pu] += size[pv];
        } else {
            parent[pv] = pu;
            size[pv] += size[pu];
        }
    }
}