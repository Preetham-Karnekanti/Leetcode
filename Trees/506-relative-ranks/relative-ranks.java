class Solution {
    public String[] findRelativeRanks(int[] score) {
        int count = 0;
        String ans[] = new String[score.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.val - a.val);
        for (int i = 0; i < score.length; i++) {
            pq.add(new Pair(score[i], i));
        }
        while (!pq.isEmpty() && count < 3) {
            Pair p = pq.poll();
            if (count == 0) {
                ans[p.idx] = "Gold Medal";
            } else if (count == 1) {
                ans[p.idx] = "Silver Medal";
            } else if (count == 2)
                ans[p.idx] = "Bronze Medal";
            count++;
        }
        count++;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            ans[p.idx] = String.valueOf(count++);
        }
        return ans;
    }
}

class Pair {
    int val;
    int idx;

    Pair(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}