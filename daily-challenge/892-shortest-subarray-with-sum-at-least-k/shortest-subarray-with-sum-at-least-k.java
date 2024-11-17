class Solution {
    public int shortestSubarray(int[] nums, int k) {
        PriorityQueue<Pair<Long, Integer>> pq = new PriorityQueue<>((a, b) -> Long.compare(a.getKey(), b.getKey()));
        long sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum >= k) {
                min = Math.min(min, i + 1);
            }

            while (!pq.isEmpty() && sum - pq.peek().getKey() >= k) {
                min = Math.min(min, i - pq.poll().getValue());
            }

            pq.add(new Pair(sum, i));
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}