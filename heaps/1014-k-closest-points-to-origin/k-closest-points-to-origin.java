class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            int one = a[0] * a[0] + a[1] * a[1];
            int two = b[0] * b[0] + b[1] * b[1];
            return Integer.compare(two, one);
        });
        for (int p[] : points) {
            pq.add(p);
            if (pq.size() > k)
                pq.poll();
        }
        return pq.toArray(new int[0][0]);
    }
}