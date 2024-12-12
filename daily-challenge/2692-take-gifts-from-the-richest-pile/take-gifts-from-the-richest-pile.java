class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> Integer.compare(b, a));
        for (int i : gifts)
            pq.add(i);
        while (k-- > 0) {
            int val = pq.poll();
            pq.add((int) Math.floor(Math.sqrt(val)));
        }

        long sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }
        return sum;
    }
}