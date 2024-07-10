class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int count = 0;
        for (int i = 0; i < time.length; i++) {
            int rem = time[i] % 60;
            int target = rem == 0 ? 0 : (60 - rem);
            count += hm.getOrDefault(target, 0);
            hm.put(rem, hm.getOrDefault(rem, 0) + 1);
        }
        return count;
    }
}