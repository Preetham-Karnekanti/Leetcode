class Solution {
    public int maxScore(List<List<Integer>> grid) {
        HashMap<String, Integer> hm = new HashMap<>();
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i <= 100; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < grid.size(); i++) {
            for (int num : grid.get(i)) {
                arr.get(num).add(i);
            }
        }

        return solve(arr, 100, 0, hm);
    }

    public int solve(List<List<Integer>> arr, int cur, int mask, HashMap<String, Integer> hm) {
        if (cur <= 0)
            return 0;
        String key = cur + ":" + mask;
        if (hm.get(key) != null)
            return hm.get(key);
        int skip = solve(arr, cur - 1, mask, hm);
        int take = 0;
        for (int row : arr.get(cur)) {
            int newMask = mask;
            if (!isBitSet(newMask, row)) {
                newMask = newMask | (1 << row);
                take = Math.max(take, cur + solve(arr, cur - 1, newMask, hm));
            }
        }
        hm.put(key, Math.max(take, skip));
        return Math.max(take, skip);
    }

    public boolean isBitSet(int num, int i) {
        num = num >> i;
        if ((num & 1) == 0)
            return false;
        return true;
    }
}