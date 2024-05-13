class Solution {
    public int fillCups(int[] amount) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : amount) {
            if (i != 0) {
                pq.add(i);
            }
        }
        int steps = 0;
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            if (a != 1)
                pq.add(a - 1);
            if (b != 1)
                pq.add(b - 1);
            steps++;
        }
        return pq.size() > 0 ? pq.poll() + steps : steps;
    }
}