class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Character.compare(b.ch, a.ch));
        int freq[] = new int[26];
        for (int i = 0; i < s.length(); i++)
            freq[s.charAt(i) - 'a']++;
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                pq.add(new Pair(freq[i], (char) (i + 'a')));
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("!");
        while (!pq.isEmpty()) {
            int last = sb.charAt(sb.length() - 1);
            Pair cur = pq.poll();
            if (last == cur.ch) {
                if (pq.isEmpty())
                    break;
                Pair next = pq.poll();
                sb.append(next.ch);
                next.count--;
                if (next.count > 0)
                    pq.add(next);
                pq.add(cur);
            } else {
                int iterations = Math.min(repeatLimit, cur.count);
                while (iterations-- > 0) {
                    sb.append(cur.ch);
                }
                cur.count = cur.count - Math.min(repeatLimit, cur.count);
                if (cur.count > 0)
                    pq.add(cur);
            }
        }
        return sb.substring(1).toString();
    }
}

class Pair {
    int count;
    char ch;

    Pair(int count, char ch) {
        this.count = count;
        this.ch = ch;
    }
}