class Solution {
    public int maxDistToClosest(int[] seats) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1)
                q.add(i);
        }
        int distance = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int cur = q.poll();
                int left = cur - 1;
                if (left >= 0 && seats[left] == 0) {
                    q.add(left);
                    seats[left] = 1;
                }
                int right = cur + 1;
                if (right < seats.length && seats[right] == 0) {
                    q.add(right);
                    seats[right] = 1;
                }
            }
            distance++;
        }
        return distance - 1;
    }
}