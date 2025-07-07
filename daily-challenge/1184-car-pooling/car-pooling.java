class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int seating[] = new int[1001];
        for (int i = 0; i < trips.length; i++) {
            seating[trips[i][1]] += trips[i][0];
            seating[trips[i][2]] -= trips[i][0];
        }
        if(seating[0] > capacity)
            return false;
        for (int i = 1; i < seating.length; i++) {
            seating[i] += seating[i - 1];
            if (seating[i] > capacity)
                return false;
        }
        return true;
    }
}