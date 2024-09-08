class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Map<Integer, Integer> counter = new TreeMap<>();
        for (int[] slot : slots1) {
            counter.put(slot[0], counter.getOrDefault(slot[0], 0) + 1);
            counter.put(slot[1], counter.getOrDefault(slot[1], 0) - 1);
        }
        for (int[] slot : slots2) {
            counter.put(slot[0], counter.getOrDefault(slot[0], 0) + 1);
            counter.put(slot[1], counter.getOrDefault(slot[1], 0) - 1);
        }

        int start = -1;
        int cnt = 0;
        for (var entry : counter.entrySet()) {
            cnt += entry.getValue();
            if (cnt == 2) {
                start = entry.getKey();
            }
            if (cnt < 2 && start > -1) {
                int len = entry.getKey() - start;
                if (len >= duration) {
                    return List.of(start, start + duration);
                } else {
                    start = -1;
                }

            }
        }
        return Collections.emptyList();
    }
}