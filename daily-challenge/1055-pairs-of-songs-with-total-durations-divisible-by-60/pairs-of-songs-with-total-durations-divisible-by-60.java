class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int remainders[] = new int[60];
        int count = 0;
        for (int i = 0; i < time.length; i++) {
            int rem = time[i] % 60;
            if (rem == 0) {
                count += remainders[0];
            } else
                count += remainders[60 - rem];
            remainders[rem]++;
        }
        return count;
    }
}