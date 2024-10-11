class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        List<int[]> events = new ArrayList<>();
        for (int i = 0; i < times.length; i++) {
            events.add(new int[] { times[i][0], i });
            events.add(new int[] { times[i][1], -i });
        }
        Collections.sort(events, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        PriorityQueue<int[]> occupiedChairs = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < times.length; i++)
            availableChairs.add(i);
        for (int[] event : events) {
            int time = event[0];
            int idx = event[1];
            while (!occupiedChairs.isEmpty() && occupiedChairs.peek()[0] <= time)
                availableChairs.add(occupiedChairs.poll()[1]);
            if (idx >= 0) {
                int chair = availableChairs.poll();
                if (idx == targetFriend)
                    return chair;
                occupiedChairs.add(new int[] { times[idx][1], chair });
            }
        }
        return -1;
    }
}