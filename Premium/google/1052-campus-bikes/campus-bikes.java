class Solution {
    class WorkerBikePair {
        int workerIndex;
        int bikeIndex;
        int distance;

        WorkerBikePair(int workerIndex, int bikeIndex, int distance) {
            this.workerIndex = workerIndex;
            this.bikeIndex = bikeIndex;
            this.distance = distance;
        }
    }

    int findDistance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }

    public int[] assignBikes(int[][] workers, int[][] bikes) {
        List<WorkerBikePair> allTriplets = new ArrayList<>();

        for (int worker = 0; worker < workers.length; worker++) {
            for (int bike = 0; bike < bikes.length; bike++) {
                int distance = findDistance(workers[worker], bikes[bike]);
                WorkerBikePair workerBikePair = new WorkerBikePair(worker, bike, distance);
                allTriplets.add(workerBikePair);
            }
        }

        Collections.sort(allTriplets, (a, b) -> {
            if (a.distance != b.distance) {
                return a.distance - b.distance;
            } else if (a.workerIndex != b.workerIndex) {
                return a.workerIndex - b.workerIndex;
            } else {
                return a.bikeIndex - b.bikeIndex;
            }
        });

        boolean bikeStatus[] = new boolean[bikes.length];
        int workerStatus[] = new int[workers.length];
        Arrays.fill(workerStatus, -1);
        int pairCount = 0;

        for (WorkerBikePair triplet : allTriplets) {
            int worker = triplet.workerIndex;
            int bike = triplet.bikeIndex;

            if (workerStatus[worker] == -1 && !bikeStatus[bike]) {
                bikeStatus[bike] = true;
                workerStatus[worker] = bike;
                pairCount++;

                if (pairCount == workers.length) {
                    return workerStatus;
                }
            }
        }

        return workerStatus;
    }
}