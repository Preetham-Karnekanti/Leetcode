class Solution {
    public int shareCandies(int[] candies, int k) {
        if (k == 0) {
            Set<Integer> unique = new HashSet<>();
            for (int can : candies) {
                unique.add(can);
            }
            return unique.size();
        }
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int can : candies) {
            cnt.put(can, cnt.getOrDefault(can, 0) + 1);
        }
        int max = 0, i = 0;
        List<Integer> window = new LinkedList<>();
        for (; i < k && i < candies.length; i++) {
            window.add(candies[i]);
            cnt.put(candies[i], cnt.getOrDefault(candies[i], 0) - 1);
            if (cnt.get(candies[i]) == 0) {
                cnt.remove(candies[i]);
            }
        }
        max = cnt.size();

        for (; i < candies.length; i++) {
            int firstE = window.isEmpty() ? 0 : window.removeFirst();
            cnt.put(firstE, cnt.getOrDefault(firstE, 0) + 1);
            window.add(candies[i]);
            cnt.put(candies[i], cnt.getOrDefault(candies[i], 0) - 1);
            if (cnt.get(candies[i]) == 0) {
                cnt.remove(candies[i]);
            }
            max = Math.max(max, cnt.size());
        }

        return max;
    }

}