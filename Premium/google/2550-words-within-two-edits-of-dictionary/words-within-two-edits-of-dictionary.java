class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();
        for (String word1 : queries) {
            for (String word2 : dictionary) {
                int i = 0, j = 0;
                int count = 0;
                while (i < word1.length() && j < word2.length()) {
                    if (word1.charAt(i) != word2.charAt(j))
                        count++;
                    if(count >= 3)
                        break;
                    i++;
                    j++;
                }
                if (count <= 2) {
                    ans.add(word1);
                    break;
                }
            }
        }
        return ans;
    }
}