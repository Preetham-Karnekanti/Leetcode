class Solution {
    public int[] sumZero(int n) {
        int answer[] = new int[n];
        int val = 1;
        int i = 0;
        int j = n - 1;
        while (i < j) {
            answer[i] = val;
            answer[j] = -val;
            val++;
            i++;
            j--;
        }
        return answer;
    }
}