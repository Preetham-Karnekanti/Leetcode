class MagicDictionary {
    HashMap<String, int[]> hm;

    public MagicDictionary() {
        hm = new HashMap<>();
    }

    public void buildDict(String[] dictionary) {
        for (String str : dictionary) {
            int freq[] = getFrequency(str);
            hm.put(str, freq);
        }
    }

    public boolean search(String searchWord) {
        for (String key : hm.keySet()) {
            if (key.length() != searchWord.length())
                continue;
            if (isPossible(key, searchWord))
                return true;
        }
        return false;
    }

    private int[] getFrequency(String str) {
        int freq[] = new int[26];
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i) - 'a']++;
        }
        return freq;
    }

    private boolean isPossible(String s1, String s2) {
        int count = 0;
        int i = 0;
        while (i < s1.length()) {
            if (s1.charAt(i) != s2.charAt(i))
                count++;
            i++;
        }
        return count == 1;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */