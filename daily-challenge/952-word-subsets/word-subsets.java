class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int maxFreq[] = new int[26];
        int freq[] = new int[26];
        for (String word : words2) {
            freq = new int[26];
            for (int i = 0; i < word.length(); i++) {
                freq[word.charAt(i) - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(freq[i], maxFreq[i]);
            }
        }

        ArrayList<String> res = new ArrayList<>();
        for (String word : words1) {
            freq = new int[26];
            for (int i = 0; i < word.length(); i++) {
                freq[word.charAt(i) - 'a']++;
            }
            boolean flag = true;
            for (int i = 0; i < 26; i++) {
                if (freq[i] < maxFreq[i]) {
                    flag = false;
                    break;
                }
            }

            if (flag)
                res.add(word);
        }
        return res;
    }
}