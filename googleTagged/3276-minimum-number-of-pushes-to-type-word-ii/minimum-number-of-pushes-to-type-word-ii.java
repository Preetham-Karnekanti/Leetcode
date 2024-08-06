class Solution {
    public int minimumPushes(String word) {
        int freq[] = new int[26];
        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }
        Arrays.sort(freq);
        int count = 0;
        int sum = 0;
        for (int i = 25; i >= 0; i--) {
            sum += freq[i] * (1 + count / 8);
            count++;
        }
        return sum;
    }
}