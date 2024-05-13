class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : piles)
            q.add(i);
        while (!q.isEmpty() && k-- > 0) {
            int cur = q.poll();
            int toBeAdded = cur % 2 == 0 ? cur / 2 : 1 + cur / 2;
            q.add(toBeAdded);
        }
        int ans = 0;
        while (!q.isEmpty())
            ans += q.poll();
        return ans;
    }
}