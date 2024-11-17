class Solution {
    Integer memo[][];

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
      PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a); // max heap
        int stops = 0, currentFuel = startFuel, prevPosition = 0;
        
        for (int[] station : stations) {
            int stationPos = station[0];
            int stationFuel = station[1];
            
            // Refuel while we can't reach the current station
            while (currentFuel < stationPos - prevPosition) {
                if (maxHeap.isEmpty()) {
                    return -1; // Not enough fuel to reach the station
                }
                currentFuel += maxHeap.poll(); // Refuel with the largest amount of fuel from previous stations
                stops++;
            }
            
            // Deduct the fuel needed to reach the current station
            currentFuel -= (stationPos - prevPosition);
            maxHeap.offer(stationFuel); // Add the current station's fuel to the heap
            prevPosition = stationPos;
        }
        
        // After the last station, check if we can reach the target
        while (currentFuel < target - prevPosition) {
            if (maxHeap.isEmpty()) {
                return -1; // Not enough fuel to reach the target
            }
            currentFuel += maxHeap.poll();
            stops++;
        }
        
        return stops;
    }

    public int helper(int index, int fuel, int stops, int target, int[][] stations) {

        if (fuel >= target) {
            return stops;
        }

        if (index == stations.length) {
            return Integer.MAX_VALUE;
        }

        if (memo[index][stops] != null) {
            return memo[index][stops];
        }

        int skipStation = helper(index + 1, fuel, stops, target, stations);

        int refuelAtStation = Integer.MAX_VALUE;
        if (fuel >= stations[index][0]) {
            refuelAtStation = helper(index + 1, fuel + stations[index][1], stops + 1, target, stations);
        }

        int result = Math.min(skipStation, refuelAtStation);
        memo[index][stops] = result;
        return result;
    }
}