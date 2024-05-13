class Solution {
    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(a);
        pq.add(b);
        pq.add(c);
        int score = 0;
        while (pq.size() > 1) {
            int aa = pq.poll();
            int ba = pq.poll();
            score++;
            if (aa != 1)
                pq.add(aa - 1);
            if (ba != 1)
                pq.add(ba - 1);
        }
        return score;
    }
}