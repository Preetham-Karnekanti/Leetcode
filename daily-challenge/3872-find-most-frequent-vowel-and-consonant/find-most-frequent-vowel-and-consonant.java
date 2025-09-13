class Solution {
    public int maxFreqSum(String s) {
        int max1 = 0;
        int max2 = 0;
        int freq[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            if (isVowel(s.charAt(i))) {
                max1 = Math.max(max1, freq[s.charAt(i) - 'a']);
            } else {
                max2 = Math.max(max2, freq[s.charAt(i) - 'a']);
            }
        }
        return max1 + max2;
    }

    public boolean isVowel(char ch) {
        return "aeiou".indexOf(ch) != -1;
    }
}