class Solution {
    public long countCompleteDayPairs(int[] hours) {
        long ans = 0;
        HashMap<Integer, Long> hm = new HashMap<>();
        for (int i = 0; i < hours.length; i++) {
            int rem = hours[i] % 24;
            int complement = (24 - rem) % 24;
            if (hm.containsKey(complement))
                ans += hm.get(complement);
            hm.put(rem, hm.getOrDefault(rem, 0L) + 1);
        }
        return ans;
    }
}