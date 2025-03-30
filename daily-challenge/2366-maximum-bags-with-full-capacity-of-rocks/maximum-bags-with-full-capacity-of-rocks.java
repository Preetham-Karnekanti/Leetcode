class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(capacity[a] - rocks[a], capacity[b] - rocks[b]));
        int count = 0;
        for (int i = 0; i < capacity.length; i++){
            int emptySpace = capacity[i] - rocks[i];
            if(emptySpace == 0){
                count++;
                continue;
            }
            pq.add(i);
        }
        while(!pq.isEmpty() && additionalRocks > 0){
            int topIdx = pq.poll();
            int emptySpace = capacity[topIdx] - rocks[topIdx];
            if(emptySpace <= additionalRocks)
                count++;
            additionalRocks -= emptySpace;
        }
        return count;
    }
}