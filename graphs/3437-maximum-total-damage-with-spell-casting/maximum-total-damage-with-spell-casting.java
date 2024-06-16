class Solution {
    public long maximumTotalDamage(int[] power) {
        TreeMap<Integer, Integer> count = new TreeMap<>();
        for (int p : power) {
            count.merge(p, 1, Integer::sum);
        }

        Map<Integer, Long> cache = new HashMap<>();

        return dfs(count.firstKey(), count, cache);
    }

    private long dfs(Integer power, TreeMap<Integer, Integer> count, Map<Integer, Long> cache) {
        if (null == power) {
            return 0;
        }

        if (cache.containsKey(power)) {
            return cache.get(power);
        }

        // pick the current power
        long pick = (long) power * count.get(power) +
        // at least power + 3
                dfs(count.ceilingKey(power + 3), count, cache);

        // unpick the current power
        long unpick = dfs(
                // at least power + 1
                count.ceilingKey(power + 1), count, cache);

        long best = Math.max(pick, unpick);
        cache.put(power, best);

        return best;
    }
}