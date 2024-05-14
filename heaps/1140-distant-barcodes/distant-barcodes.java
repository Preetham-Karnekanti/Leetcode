class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i : barcodes)
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        for (int key : hm.keySet())
            pq.add(new Pair(key, hm.get(key)));
        int ans[] = new int[barcodes.length];
        int j = 0;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            for (int i = 0; i < p.freq; i++) {
                if (j >= ans.length)
                    j = 1;
                ans[j] = p.val;
                j += 2;
            }
        }
        return ans;
    }
}

class Pair {
    int val;
    int freq;

    Pair(int v, int f) {
        val = v;
        freq = f;
    }
}