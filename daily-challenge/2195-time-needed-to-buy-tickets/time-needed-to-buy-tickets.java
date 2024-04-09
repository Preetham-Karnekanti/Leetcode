class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < tickets.length; i++)
            q.add(i);
        int count = 0;
        while (tickets[k] != 0) {
            count++;
            int idx = q.poll();
            tickets[idx]--;
            if (tickets[idx] > 0)
                q.add(idx);
            if (tickets[k] == 0)
                break;
        }
        return count;
    }
}