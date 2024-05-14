class Solution {
    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        long ans[] = new long[queries.length];
        long sum = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.val == b.val)
                return a.idx - b.idx;
            return a.val - b.val;
        });

        for (int i = 0; i < nums.length; i++) {
            pq.add(new Pair(nums[i], i));
            sum += nums[i];
        }
        int i = 0;
        HashSet<Integer> marked = new HashSet<>();
        for (int[] q : queries) {
            int idx = q[0];
            int k = q[1];
            if(!marked.contains(idx)){
                sum -= nums[idx];
            }
            marked.add(idx);
            while(!pq.isEmpty() && k > 0){
                if(!marked.contains(pq.peek().idx)){
                    marked.add(pq.peek().idx);
                    sum -= pq.peek().val;
                    k--;

                }
                pq.poll();
            }
            ans[i++] = sum;
        }

        return ans;
    }
}

class Pair {
    int val;
    int idx;

    Pair(int v, int i) {
        val = v;
        idx = i;
    }
}