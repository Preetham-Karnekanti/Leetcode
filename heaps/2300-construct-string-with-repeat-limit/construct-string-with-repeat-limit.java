class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Character.compare(b.ch, a.ch));
        for (char c : hm.keySet()) {
            pq.add(new Pair(c, hm.get(c)));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("$");
        while (!pq.isEmpty()) {
            char last = sb.charAt(sb.length() - 1);
            Pair cur = pq.poll();
            if (cur.ch == last) {
                if (pq.isEmpty())
                    break;
                Pair temp = pq.poll();
                sb.append(temp.ch);
                temp.count--;
                if (temp.count != 0)
                    pq.add(temp);
                pq.add(cur);
            } else {
                int count = cur.count;
                if (count <= repeatLimit) {
                    while (count-- != 0) {
                        sb.append(cur.ch);
                    }
                } else {
                    int temp = repeatLimit;
                    cur.count = cur.count - repeatLimit;
                    while (temp-- > 0) {
                        sb.append(cur.ch);
                    }
                    pq.add(cur);
                }
            }

        }
        return sb.substring(1).toString();
    }
}

class Pair {
    char ch;
    int count;

    Pair(char c, int ct) {
        ch = c;
        count = ct;
    }
}