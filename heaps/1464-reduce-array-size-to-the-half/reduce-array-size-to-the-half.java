class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i : arr) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i : hm.keySet()) {
            pq.add(new int[] { i, hm.get(i) });
        }
        int n = arr.length / 2;
        int removed = 0;
        int count = 0;
        while (!pq.isEmpty()) {
            removed += pq.poll()[1];
            count++;
            if (removed >= n)
                return count;
        }
        return count;
    }
}