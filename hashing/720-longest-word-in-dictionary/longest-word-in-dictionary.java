class Solution {
    public String longestWord(String[] words) {
        String ans = "";
        HashSet<String> hs = new HashSet<>();
        for (String word : words) {
            hs.add(word);
        }

        for (String word : words) {
            if (hasAllPrefixes(word, hs)) {
                if (ans.length() <= word.length()) {
                    if (ans.length() == word.length()) {
                        if (ans.compareTo(word) > 0) {
                            ans = word;
                        }
                    } else {
                        ans = word;
                    }
                }
            }
        }
        return ans;
    }

    public boolean hasAllPrefixes(String word, HashSet<String> hs) {

        for (int i = 1; i < word.length(); i++) {
            String temp = word.substring(0, i);
            if (!hs.contains(temp))
                return false;
        }

        return true;
    }
}