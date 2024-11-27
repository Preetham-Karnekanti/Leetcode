class WordDistance {

    HashMap<String, ArrayList<Integer>> hm;

    public WordDistance(String[] wordsDict) {
        hm = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {
            hm.putIfAbsent(wordsDict[i], new ArrayList<>());
            hm.get(wordsDict[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        ArrayList<Integer> word1Id = hm.get(word1);
        ArrayList<Integer> word2Id = hm.get(word2);

        int min = Integer.MAX_VALUE;

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

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */