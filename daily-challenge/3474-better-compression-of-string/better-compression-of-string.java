class Solution {
    public String betterCompression(String compressed) {
        int freq[] = new int[26];
        int n = compressed.length();
        for (int i = 0; i < n; i++) {
            char ch = compressed.charAt(i);
            int j = i + 1;
            int number = 0;
            while (j < n && Character.isDigit(compressed.charAt(j))) {
                number = number * 10 + (compressed.charAt(j) - '0');
                j++;
            }
            freq[ch - 'a'] += number;
            i = j - 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                sb.append((char) (i + 'a'));
                sb.append(freq[i]);
            }
        }
        return sb.toString();
    }
}