class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) {
            return false;
        }

        Map<String, Set<String>> similarMap = new HashMap<>();

        for (List<String> pair : similarPairs) {
            similarMap.computeIfAbsent(pair.get(0), k -> new HashSet<>()).add(pair.get(1));
            similarMap.computeIfAbsent(pair.get(1), k -> new HashSet<>()).add(pair.get(0));
        }

        for (int i = 0; i < sentence1.length; i++) {
            String word1 = sentence1[i];
            String word2 = sentence2[i];

            if (word1.equals(word2)) {
                continue;
            }

            if (similarMap.getOrDefault(word1, new HashSet<>()).contains(word2) == false &&
                    similarMap.getOrDefault(word2, new HashSet<>()).contains(word1) == false) {
                return false;
            }
        }

        return true;
    }
}