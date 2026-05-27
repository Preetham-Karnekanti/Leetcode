class Solution {
    public int numberOfSpecialChars(String word) {
        int freqLower[] = new int[26];
        int freqUpper[] = new int[26];
        Arrays.fill(freqLower, -1);
        Arrays.fill(freqUpper, Integer.MAX_VALUE);
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                freqLower[ch - 'a'] = i;
            } else {
                freqUpper[ch - 'A'] = Math.min(freqUpper[ch - 'A'], i);
            }
        }
        for (int i = 0; i < 26; i++) {
            if (freqLower[i] != -1 && freqUpper[i] != Integer.MAX_VALUE && freqLower[i] < freqUpper[i])
                count++;
        }
        return count;
    }
}