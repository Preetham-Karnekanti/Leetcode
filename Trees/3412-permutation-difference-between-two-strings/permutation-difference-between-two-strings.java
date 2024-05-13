class Solution {
    public int findPermutationDifference(String s, String t) {
        int freq[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a'] = i;
        }
        int sum = 0;
        for (int i = 0; i < t.length(); i++) {
            sum += Math.abs(freq[t.charAt(i) - 'a'] - i);
        }

        return sum;
    }
}