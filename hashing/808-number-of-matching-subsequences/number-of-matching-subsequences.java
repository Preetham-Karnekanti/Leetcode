class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        HashMap<String, Integer> hm = new HashMap<>();
        for (String word : words) {
            hm.put(word, hm.getOrDefault(word, 0) + 1);
        }
        for (String word : hm.keySet()) {
            int val = hm.get(word);
            if (isSubsequence(s, word))
                count+=val;
        }
        return count;
    }

    public boolean isSubsequence(String s, String t) {
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(j)) {
                j++;
            }
            if (j == t.length())
                return true;
        }
        return false;
    }
}