class Solution {
    public String alienOrder(String[] words) {
        HashMap<Character, List<Character>> adj = new HashMap<>();
        HashMap<Character, Integer> count = new HashMap<>();
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                count.put(ch, 0);
                adj.putIfAbsent(ch, new ArrayList<>());
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            if (word1.length() > word2.length() && word1.startsWith(word2))
                return "";
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    adj.get(word1.charAt(j)).add(word2.charAt(j));
                    count.put(word2.charAt(j), count.get(word2.charAt(j)) + 1);
                    break;
                }
            }
        }
        String s = "";
        Queue<Character> q = new LinkedList<>();
        for (Character ch : count.keySet()) {
            if (count.get(ch).equals(0))
                q.add(ch);
        }
        while (!q.isEmpty()) {
            char ch = q.poll();
            s += ch;
            for (Character next : adj.get(ch)) {
                count.put(next, count.get(next) - 1);
                if (count.get(next).equals(0))
                    q.add(next);
            }
        }
        return s.length() < count.size() ? "" : s;
    }
}