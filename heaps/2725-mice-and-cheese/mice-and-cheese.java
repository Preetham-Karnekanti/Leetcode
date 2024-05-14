class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.reward - a.reward);
        int n = reward1.length;
        for (int i = 0; i < n; i++) {
            pq.add(new Pair(reward1[i] - reward2[i], i));
        }
        HashSet<Integer> hs = new HashSet<>();
        int total = 0;
        while (k-- > 0) {
            Pair cur = pq.poll();
            hs.add(cur.idx);
            total += reward1[cur.idx];
        }
        for (int i = 0; i < n; i++) {
            if (hs.contains(i))
                continue;
            total += reward2[i];
        }

        return total;
    }
}

class Pair {
    int reward;
    int idx;

    Pair(int reward, int idx) {
        this.reward = reward;
        this.idx = idx;
    }
}