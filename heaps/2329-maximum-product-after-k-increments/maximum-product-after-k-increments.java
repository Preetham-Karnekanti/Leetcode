class Solution {
    public int maximumProduct(int[] nums, int k) {
        long ans = 1;
        int m = (int) 1e9 + 7;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : nums)
            pq.add(i);
        while (k-- > 0) {
            pq.add(pq.poll() + 1);
        }
        while (!pq.isEmpty()) {
            ans *= pq.poll();
            ans %= m;
        }
        return (int) ans;
    }
}