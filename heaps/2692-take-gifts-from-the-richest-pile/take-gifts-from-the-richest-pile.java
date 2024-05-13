class Solution {
    public long pickGifts(int[] gifts, int k) {
        long ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int i : gifts)
            pq.add(i);
        while (!pq.isEmpty() && k-- > 0) {
            int cur = pq.poll();
            int remaining = (int) Math.floor(Math.sqrt(cur));
            pq.add(remaining);
        }
        while (!pq.isEmpty())
            ans += pq.poll();
        return ans;
    }
}