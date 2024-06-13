class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, Integer> hm = new HashMap<>();
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (hm.get(mail) == null)
                    hm.put(mail, i);
                else {
                    ds.unionBySize(i, hm.get(mail));
                }
            }
        }
        List<List<String>> mergedMail = new ArrayList<>();
        for (int i = 0; i < n; i++)
            mergedMail.add(new ArrayList<>());
        for (String mail : hm.keySet()) {
            int parent = ds.findParent(hm.get(mail));
            mergedMail.get(parent).add(mail);
        }
        List<List<String>> mergedWithName = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (mergedMail.get(i).size() == 0)
                continue;
            ArrayList<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            Collections.sort(mergedMail.get(i));
            temp.addAll(mergedMail.get(i));
            mergedWithName.add(temp);

        }
        return mergedWithName;
    }
}

class DisjointSet {
    int parent[], size[];

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

    public void unionBySize(int u, int v) {
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