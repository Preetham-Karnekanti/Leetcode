class Solution {
    public int minTransfers(int[][] transactions) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int t[] : transactions) {
            hm.put(t[0], hm.getOrDefault(t[0], 0) - t[2]);
            hm.put(t[1], hm.getOrDefault(t[1], 0) + t[2]);
        }
        ArrayList<Integer> credit = new ArrayList<>();
        for (int i : hm.values()) {
            if (i != 0)
                credit.add(i);
        }
        int n = credit.size();
        return dfs(credit, 0, n);
    }

    public int dfs(ArrayList<Integer> credit, int cur, int n) {
        while (cur < n && credit.get(cur) == 0)
            cur++;
        if (cur == n)
            return 0;
        int cost = Integer.MAX_VALUE;
        for (int next = cur + 1; next < n; next++) {
            if (credit.get(cur) * credit.get(next) < 0) {
                credit.set(next, credit.get(next) + credit.get(cur));
                cost = Math.min(cost, 1 + dfs(credit, cur + 1, n));
                credit.set(next, credit.get(next) - credit.get(cur));
            }
        }
        return cost;
    }
}