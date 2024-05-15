class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> a.val.equals(b.val) ? b.idx - a.idx : b.val.compareTo(a.val));
        int ans[] = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int k = queries[i][0];
            int x = queries[i][1];
            for (int j = 0; j < nums.length; j++) {
                String temp = nums[j].substring(nums[j].length() - x);
                pq.add(new Pair(temp, j));
                if (pq.size() > k)
                    pq.poll();
            }
            ans[i] = pq.peek().idx;
            pq.clear();
        }
        return ans;
    }
}

class Pair {
    int idx;
    String val;

    Pair(String v, int idx) {
        val = v;
        this.idx = idx;
    }
}