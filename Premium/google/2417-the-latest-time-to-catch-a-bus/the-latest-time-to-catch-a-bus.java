class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        HashSet<Integer> set = new HashSet<>();
        int ans = 0, j = 0;

        for (int i = 0; i < passengers.length; i++)
            set.add(passengers[i]);

        for (int i = 0; i < buses.length; i++) {
            int space = capacity;
            while (j < passengers.length && space > 0 && passengers[j] <= buses[i]) {
                ans = passengers[j];
                j++;
                space--;
            }
            if (space != 0)
                ans = buses[i];
        }

        while (set.contains(ans))
            ans--;

        return ans;
    }
}