class Solution {
    public int longestSquareStreak(int[] nums) {
        HashSet<Long> hs = new HashSet<>();
        for(int i: nums){
            hs.add((long)i);
        }
        int max = 0;
        for (long i : hs) {            
            long next = i * i;
            int len = 1;
            while (hs.contains(next)) {
                next *= next;
                len++;
            }
            max = Math.max(len, max);
        }
        return max >= 2 ? max : -1;
    }
}