class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int prefix[] = new int[n + 2];
        for (int i[] : bookings) {
            int f = i[0];
            int l = i[1];
            int t = i[2];
            prefix[f] += t;
            prefix[l + 1] -= t;
        }
        for (int i = 1; i <= n; i++) {
            prefix[i] += prefix[i - 1];
        }
        int answer[] = new int[n];
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            answer[idx++] = prefix[i];
        }
        return answer;
    }
}