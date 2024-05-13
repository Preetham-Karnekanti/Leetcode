class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : stones)
            pq.add(i);
        while (pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();
            if (Math.abs(y - x) != 0)
                pq.add(Math.abs(y - x));
        }

        return pq.size() == 0 ? 0 : pq.poll();
    }
}