class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int mSum = 0;
        for (int i : rolls) {
            mSum += i;
        }
        int nSum = mean * (n + m) - mSum;
        if (nSum > n * 6 || nSum < n)
            return new int[0];
        int answer[] = new int[n];
        int eachObservation = nSum / n;
        int remaining = nSum % n;
        Arrays.fill(answer, eachObservation);
        for (int i = 0; i < remaining; i++)
            answer[i]++;
        return answer;
    }
}