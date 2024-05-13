class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Integer.compare(y.count, x.count));
        if (a > 0)
            pq.add(new Pair('a', a));
        if (b > 0)
            pq.add(new Pair('b', b));
        if (c > 0)
            pq.add(new Pair('c', c));
        StringBuilder sb = new StringBuilder();
        sb.append("zz");
        while (!pq.isEmpty()) {
            int last = sb.charAt(sb.length() - 1);
            int lastButOne = sb.charAt(sb.length() - 2);
            Pair cur = pq.poll();
            if (last == cur.ch && lastButOne == cur.ch) {
                if (pq.isEmpty())
                    break;
                Pair temp = pq.poll();
                sb.append(temp.ch);
                temp.count--;
                if (temp.count != 0)
                    pq.add(temp);
            }
            sb.append(cur.ch);
            cur.count--;
            if (cur.count != 0)
                pq.add(cur);
        }
        return sb.substring(2).toString();
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