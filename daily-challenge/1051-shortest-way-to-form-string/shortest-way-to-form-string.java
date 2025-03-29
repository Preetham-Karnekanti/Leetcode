class Solution {
    public int shortestWay(String source, String target) {
        int freq[] = new int[26];
        for (int i = 0; i < source.length(); i++) {
            freq[source.charAt(i) - 'a']++;
        }
        int freq2[] = new int[26];
        for (int i = 0; i < target.length(); i++) {
            freq2[target.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (freq2[i] > 0 && freq[i] == 0)
                return -1;
        }
        String temp = source;
        int ops = 1;
        while (isSubsequence(target, temp) == false) {
            ops++;
            temp += source;
        }
        return ops;
    }

    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}