class Solution {
    public int maxBalancedShipments(int[] weight) {
        int n = weight.length;
        int max = 0;          // Tracks the max weight in the current potential shipment
        int shipment = 0;     // Counts number of valid balanced shipments

        for(int i = 0; i < n; i++) {
            max = Math.max(max, weight[i]); // Update max weight so far in the current segment

            if(weight[i] < max) {           // Check if current parcel can be the end of a balanced shipment
                shipment++;                 // We found a valid balanced shipment
                max = 0;                    // Reset max for the next potential shipment
            }
        }

        return shipment; // Return the total number of balanced shipments found
    }
}