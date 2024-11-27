class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        HashMap<String, ArrayList<Integer>> hm;
        hm = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {
            hm.putIfAbsent(wordsDict[i], new ArrayList<>());
            hm.get(wordsDict[i]).add(i);
        }

        ArrayList<Integer> word1Id = hm.get(word1);
        ArrayList<Integer> word2Id = hm.get(word2);

        int min = Integer.MAX_VALUE;
        if (word1.equals(word2)) {
            for (int i = 0; i < word1Id.size() - 1; i++) {
                min = Math.min(min, word1Id.get(i + 1) - word1Id.get(i));
            }
            return min;
        }

        int i = 0;
        int j = 0;
        while (i < word1Id.size() && j < word2Id.size()) {
            int distance = Math.abs(word1Id.get(i) - word2Id.get(j));
            min = Math.min(min, distance);
            if (word1Id.get(i) < word2Id.get(j)) {
                i++;
            } else
                j++;
        }
        return min;
    }
}