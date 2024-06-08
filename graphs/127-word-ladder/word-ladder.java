class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> hs = new HashSet<>(wordList);
        if (!hs.contains(endWord))
            return 0;
        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        visited.add(beginWord);
        int steps = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String cur = q.poll();
                if (cur.equals(endWord))
                    return steps;
                char ch[] = cur.toCharArray();
                for (int i = 0; i < ch.length; i++) {
                    char tempChar = ch[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        ch[i] = c;
                        String temp = new String(ch);
                        if (hs.contains(temp) && visited.contains(temp) == false) {
                            q.add(temp);
                            visited.add(temp);
                        }
                    }
                    ch[i] = tempChar;
                }
            }
            steps++;
        }
        return 0;
    }
}